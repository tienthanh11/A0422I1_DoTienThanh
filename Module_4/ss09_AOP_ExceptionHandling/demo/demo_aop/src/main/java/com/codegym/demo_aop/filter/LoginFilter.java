package com.codegym.demo_aop.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = "/*")
@Component
public class LoginFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpSession session = ((HttpServletRequest) req).getSession();
//        User user = (User) session.getAttribute("user");
//        System.out.println(((HttpServletRequest) req).getRequestURI());
//        if ((user != null && user.getUsername() != null)
//                || ((HttpServletRequest) req).getRequestURI().contains("login")
//                || ((HttpServletRequest) req).getRequestURI().contains("/api/")) {
            chain.doFilter(req, resp);
//            return;
//        }
//        ((HttpServletResponse) resp).sendRedirect("/login");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
