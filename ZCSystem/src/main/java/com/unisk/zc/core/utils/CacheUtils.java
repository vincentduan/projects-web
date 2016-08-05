package com.unisk.zc.core.utils;

import com.unisk.zc.utils.springs.SpringContextHolder;

import net.sf.ehcache.*;
import net.sf.ehcache.config.CacheConfiguration;

// Referenced classes of package bjxask.emvc.core.utils:
//            SpringContextHolder

public class CacheUtils
{

    private static CacheManager cacheManager = (CacheManager)SpringContextHolder.getBean("cacheManager");
    private static final String SYS_CACHE = "sysCache";

    public CacheUtils()
    {
    }

    public static Object get(String key)
    {
        return get("sysCache", key);
    }

    public static void put(String key, Object value)
    {
        put("sysCache", key, value);
    }

    public static void remove(String key)
    {
        remove("sysCache", key);
    }

    public static Object get(String cacheName, String key)
    {
        Element element = getCache(cacheName).get(key);
        return element != null ? element.getObjectValue() : null;
    }

    public static void put(String cacheName, String key, Object value)
    {
        Element element = new Element(key, value);
        getCache(cacheName).put(element);
    }

    public static void remove(String cacheName, String key)
    {
        getCache(cacheName).remove(key);
    }

    private static Cache getCache(String cacheName)
    {
        Cache cache = cacheManager.getCache(cacheName);
        if(cache == null)
        {
            cacheManager.addCache(cacheName);
            cache = cacheManager.getCache(cacheName);
            cache.getCacheConfiguration().setEternal(true);
        }
        return cache;
    }

    public static CacheManager getCacheManager()
    {
        return cacheManager;
    }

}
