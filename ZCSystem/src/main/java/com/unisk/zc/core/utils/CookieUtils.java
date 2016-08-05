// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CookieUtils.java

package com.unisk.zc.core.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;

import com.unisk.zc.utils.springs.SpringContextHolder;


// Referenced classes of package bjxask.emvc.core.utils:
//            SpringContextHolder, StringUtils

public class CookieUtils
{

    public CookieUtils()
    {
    }

    public static void setCookie(HttpServletResponse response, String name, String value)
    {
        setCookie(response, name, value, 0x15180);
    }

    public static void setCookie(HttpServletResponse response, String name, String value, int maxAge)
    {
        Cookie cookie = new Cookie(name, null);
        if(StringUtils.isNotBlank(SpringContextHolder.getApplicationContext().getApplicationName()))
            cookie.setPath(SpringContextHolder.getApplicationContext().getApplicationName());
        else
            cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        try
        {
            cookie.setValue(URLEncoder.encode(value, "utf-8"));
        }
        catch(UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        response.addCookie(cookie);
    }

    public static String getCookie(HttpServletRequest request, String name)
    {
        return getCookie(request, null, name, false);
    }

    public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name)
    {
        return getCookie(request, response, name, true);
    }

    public static String getCookie(HttpServletRequest request, HttpServletResponse response, String name, boolean isRemove)
    {
        String value = null;
        Cookie cookies[] = request.getCookies();
        if(cookies != null)
        {
            Cookie acookie[];
            int j = (acookie = cookies).length;
            for(int i = 0; i < j; i++)
            {
                Cookie cookie = acookie[i];
                if(cookie.getName().equals(name))
                {
                    try
                    {
                        value = URLDecoder.decode(cookie.getValue(), "utf-8");
                    }
                    catch(UnsupportedEncodingException e)
                    {
                        e.printStackTrace();
                    }
                    if(isRemove)
                    {
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }

        }
        return value;
    }
}
