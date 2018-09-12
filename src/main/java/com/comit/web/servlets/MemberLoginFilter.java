package com.comit.web.servlets;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;

@WebFilter("/mbr/*")
public class MemberLoginFilter implements Filter  {

    @Override
    public void init(FilterConfig config) throws ServletException {
        // If you have any <init-param> in web.xml, then you could get them
        // here by config.getInitParameter("name") and assign it as field.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/login.do"); // No logged-in user found, so redirect to login page.
        } else {
        	// verify if user logged in has administration privileges
        	if (session.getAttribute("user.utype") == "MBR") {
        		response.sendRedirect(request.getContextPath() + "/home");
        	} else {
        		chain.doFilter(req, res); // user is a administrator.
        	}
        }
    }

    @Override
    public void destroy() {
        // If you have assigned any expensive resources as field of
        // this Filter class, then you could clean/close them here.
    }
}