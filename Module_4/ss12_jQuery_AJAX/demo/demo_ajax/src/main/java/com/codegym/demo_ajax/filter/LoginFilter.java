package com.codegym.demo_ajax.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String path = request.getServletPath();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
//        if (path.contains("/login") || path.contains("/student/list") || path.contains("css") || path.contains("vendor")
//         || path.contains("js")) {
//            chain.doFilter(req, resp);
//        } else if (username == null) {
//            response.sendRedirect("/login");
//        } else {
//            chain.doFilter(req, resp);
//        }
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
