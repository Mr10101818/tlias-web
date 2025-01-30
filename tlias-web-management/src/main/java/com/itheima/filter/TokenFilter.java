package com.itheima.filter;


import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@WebFilter(urlPatterns = "/*")
@Slf4j
public class TokenFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        String requestURI=request.getRequestURI();

        if(requestURI.contains("/login")){
            filterChain.doFilter(request,response);
            return;
        }
        String token=request.getHeader("token");
        if(token==null|| token.isEmpty()){
            log.info("令牌为空，响应401");
            response.setStatus(401);
            return;
        }
        try {
            JwtUtils.parseToken(token);
        } catch (Exception e){
            log.info("令牌解析失败，响应401");
            response.setStatus(401);
            return;
        }

        log.info("令牌解析成功，放行");
        filterChain.doFilter(request,response);

    }
}
