package com.comit.web.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comit.web.services.RegistrationService;

@WebServlet("/deleteregistration")
public class DeleteRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistrationService registrationService = new RegistrationService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date todaysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		int member_id = Integer.parseInt(request.getParameter("memberidDel"));
		
		registrationService.deleteMember(member_id);
		
		request.setAttribute("currDate", sdf.format(todaysDate));
		request.setAttribute("members", registrationService.getRegisterMembers());
		request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
	}

}
