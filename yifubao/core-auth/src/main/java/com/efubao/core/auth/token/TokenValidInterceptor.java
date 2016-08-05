package com.efubao.core.auth.token;

import java.lang.reflect.Method;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * token interceptor
 * 来源于V
 */
public class TokenValidInterceptor extends HandlerInterceptorAdapter {
    /** default token timeout */
    private static final long TIMEOUT_DEFAULT = 10800L;
    /**  */
    @Resource(name = "tokenRedisTemplate")
    private RedisTemplate<String, String> redisTemplate;
    /** token name */
    private String tokenName = "_ls_token";
    /** token timeout in seconds */
    private long timeout = TIMEOUT_DEFAULT;
    
    /**
     * constructor
     * @param redisTemplate 
     */
    public TokenValidInterceptor(final RedisTemplate<String, String> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
            Object handler) throws Exception {
        if(!(handler instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;  
        Method method = handlerMethod.getMethod();
        TokenValid annotation = method.getAnnotation(TokenValid.class);
        if (annotation == null) {
            return true;
        }
        if (annotation.saveToken()) {
            String uuid = UUID.randomUUID().toString();
            request.setAttribute(this.tokenName, uuid);
            redisTemplate.opsForValue().set(uuid, "token", this.timeout, TimeUnit.SECONDS);
            return true;
        }
        if (annotation.removeToken()) {
            String clinetToken = request.getParameter(this.tokenName);
            if(StringUtils.isBlank(clinetToken)){
            	return false;
            }
            if(StringUtils.isBlank(redisTemplate.opsForValue().get(clinetToken))){
                throw new TokenInvalidException("您点的太快了，以至于系统认为是点了两次。如果您只点了一次，会有两种可能: 1、鼠标连击(检查下修改的内容是不是已经保存上) 2、这个页面打开的时间超过了3小时(修改的内容是不会被保存的) 处理办法: 把页面关掉重新来一次。请不要使用带有迅雷、360插件的浏览器进行操作");
            }
            redisTemplate.delete(clinetToken);
        }
        return true;
    }
    
    // ----------------------- getters and setters -----------------------
    
    public void setTokenName(String tokenName) {
        this.tokenName = tokenName;
    }

    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }
}
