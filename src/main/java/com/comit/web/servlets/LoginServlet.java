package com.comit.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comit.web.classes.User;
import com.comit.web.services.UserValidationService;

@WebServlet(urlPatterns="/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserValidationService userValidationService = new UserValidationService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean isUserValid = userValidationService.isUserValid(username, password);
		
		if (isUserValid) {
			
			User user = userValidationService.getUserByUsername(username);
			request.getSession().setAttribute("user", user);
			response.sendRedirect("/home");
		}
		else {
			request.setAttribute("errMsg", "Username and/or password is incorrect!");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}
	}
}
