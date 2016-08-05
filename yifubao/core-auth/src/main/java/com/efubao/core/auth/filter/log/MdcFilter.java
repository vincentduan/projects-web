package com.efubao.core.auth.filter.log;

import org.slf4j.MDC;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 让slf4j日志中可以输出IP，session ID和用户名
 */
public class MdcFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        MDC.put("IP", request.getRemoteAddr());

        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);
        if(session != null) {
            MDC.put("sessionId", session.getId());
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            MDC.put("userName", authentication.getName());
        }

        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("IP");
            if(session != null) {
                MDC.remove("sessionId");
            }
            if (authentication != null) {
                MDC.remove("userName");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
