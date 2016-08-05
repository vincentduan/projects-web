/**
 * RedisSessionRegistry.java
 * Copyright (c) 2013 by efubao.com
 */
package com.efubao.core.auth.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.core.session.SessionDestroyedEvent;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.util.Assert;

/**
 * save session in Redis
 *
 */
public class RedisSessionRegistry extends SessionRegistryImpl {
    /** logger */
    private final Log logger = LogFactory.getLog(RedisSessionRegistry.class);
    /**  */
    @Resource(name = "sessionRedisTemplate")
    /**  */
    private RedisTemplate<String, SessionInformation> sessionRedisTemplate;
    /**  */
    @Resource(name = "sessionRedisTemplate")
    private RedisTemplate<String, String> principalRedisTemplate;
    
    @Override
    public List<Object> getAllPrincipals() {
        Set<String> all = principalRedisTemplate.opsForSet().members(this.buildPrincipalsAllKey());
        if (all == null) {
            return new ArrayList<Object>();
        }
        return new ArrayList<Object>(all);
    }
    
    @Override
    public List<SessionInformation> getAllSessions(Object principal, boolean includeExpiredSessions) {
        final Set<String> sessions = this.getSessionsByPrincipal(principal);
        if (sessions == null) {
            return Collections.emptyList();
        }
        List<SessionInformation> list = new ArrayList<SessionInformation>(sessions.size());
        for (String sessionId : sessions) {
            SessionInformation si = this.getSessionInformation(sessionId);
            if (si == null) {
                continue;
            }
            if (includeExpiredSessions || !si.isExpired()) {
                list.add(si);
            }
        }
        return list;
    }
    
    @Override
    public SessionInformation getSessionInformation(String sessionId) {
        Assert.hasText(sessionId, "SessionId required as per interface contract");
        return sessionRedisTemplate.opsForValue().get(this.buildSessionIdKey(sessionId));
    }
    
    @Override
    public void refreshLastRequest(String sessionId) {
        Assert.hasText(sessionId, "SessionId required as per interface contract");
        SessionInformation si = this.getSessionInformation(sessionId);
        if (si != null) {
            si.refreshLastRequest();
            sessionRedisTemplate.opsForValue().set(this.buildSessionIdKey(sessionId), si);
        }
    }

    @Override
    public void registerNewSession(String sessionId, Object principal) {
        Assert.hasText(sessionId, "SessionId required as per interface contract");
        Assert.notNull(principal, "Principal required as per interface contract");
        if (logger.isDebugEnabled()) {
            logger.debug("Registering session " + sessionId + ", for principal " + principal);
        }
        if (this.getSessionInformation(sessionId) != null) {
            this.removeSessionInformation(sessionId);
        }
        sessionRedisTemplate.opsForValue().set(this.buildSessionIdKey(sessionId), new SessionInformation(principal, sessionId, new Date()));
        principalRedisTemplate.opsForSet().add(this.buildPrincipalKey(principal), sessionId);
    }
    
    @Override
    public void removeSessionInformation(String sessionId) {
        Assert.hasText(sessionId, "SessionId required as per interface contract");
        SessionInformation si = this.getSessionInformation(sessionId);
        if (si == null) {
            return;
        }
        if (logger.isTraceEnabled()) {
            logger.debug("Removing session " + sessionId + " from set of registered sessions");
        }
        sessionRedisTemplate.delete(this.buildSessionIdKey(sessionId));
        Set<String> sessionsUsedByPrincipal = this.getSessionsByPrincipal(si.getPrincipal());
        if (sessionsUsedByPrincipal == null) {
            return;
        }
        if (logger.isDebugEnabled()) {
            logger.debug("Removing session " + sessionId + " from principal's set of registered sessions");
        }
        sessionsUsedByPrincipal.remove(sessionId);
        String principalKey = this.buildPrincipalKey(si.getPrincipal());
        principalRedisTemplate.opsForSet().remove(principalKey, sessionId);
        if (sessionsUsedByPrincipal.isEmpty()) {
            // No need to keep object in principals Map anymore
            if (logger.isDebugEnabled()) {
                logger.debug("Removing principal " + si.getPrincipal() + " from registry");
            }
            principalRedisTemplate.delete(principalKey);
        }
        if (logger.isTraceEnabled()) {
            logger.trace("Sessions used by '" + si.getPrincipal() + "' : " + sessionsUsedByPrincipal);
        }
    }
    
    @Override
    public void onApplicationEvent(SessionDestroyedEvent event) {
        this.removeSessionInformation(event.getId());
    }
    
    /**
     * get session by principal
     * @param principal 
     * @return
     */
    private Set<String> getSessionsByPrincipal(Object principal) {
        return principalRedisTemplate.opsForSet().members(this.buildPrincipalKey(principal));
    }
    
    /**
     * build session ID key
     * @param sessionId 
     * @return
     */
    private String buildSessionIdKey(String sessionId) {
        return RedisSessionRegistry.class.getName() + "_" + sessionId;
    }

    /**
     * @return
     */
    private String buildPrincipalsAllKey() {
        return RedisSessionRegistry.class.getName() + "_ALL_LIST";
    }

    /**
     * build principal key
     * @param principal 
     * @return
     */
    private String buildPrincipalKey(Object principal) {
        // return RedisSessionRegistry.class.getName() + "_" + ((org.springframework.security.core.userdetails.User) principal).getUsername();
        return RedisSessionRegistry.class.getName() + "_" +  principal;
    }

}
