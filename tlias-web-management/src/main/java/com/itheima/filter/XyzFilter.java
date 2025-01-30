package com.itheima.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class XyzFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init 初始化方法...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("拦截到了请求...放行前");
        filterChain.doFilter(servletRequest,servletResponse);
        log.info("拦截到了响应...放行后");
    }

    @Override
    public void destroy() {
        log.info("destroy 销毁方法...");
    }
}
