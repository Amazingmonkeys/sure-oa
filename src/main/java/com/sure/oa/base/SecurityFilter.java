package com.sure.oa.base;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter("/*") //过滤器拦截所有地址
public class SecurityFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        //禁用缓存
        httpServletResponse.addHeader("Pragma", "no-cache");
        httpServletResponse.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        httpServletResponse.addHeader("Cache-Control", "pre-check=0, post-check=0");
        httpServletResponse.setDateHeader("Expires", 0);

        String path = httpServletRequest.getServletPath();
        if (path.startsWith("/security/login")) {
            filterChain.doFilter(servletRequest, servletResponse); //放行通过
            return;
        }
        HttpSession session = httpServletRequest.getSession();
        CurrUser currUser = (CurrUser) session.getAttribute(Constants.SESSION_ATTR_CURRUSER);
        if (currUser != null) { //已登录
            filterChain.doFilter(servletRequest, servletResponse); //放行通过
            return;
        }
        //接受跨域访问
        httpServletResponse.setHeader("Access-Control-Allow-Origin", httpServletRequest.getHeader("Origin"));
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
        httpServletResponse.setHeader("Access-Control-Max-Age", "0");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With,userId,token");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpServletResponse.setHeader("XDomainRequestAllowed","1");

        //否则为非法访问，向客户端发送表达未登录的JSON信息
        PrintWriter out = httpServletResponse.getWriter(); //获得向浏览器输出信息的输出流
        out.print("{\"logined\": false}");
    }

    @Override
    public void destroy() {

    }
}
