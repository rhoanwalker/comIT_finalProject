package com.comit.web.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comit.web.classes.Member;
import com.comit.web.services.RegistrationService;


@WebServlet("/updateregistration.do")
public class UpdateRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RegistrationService registrationService = new RegistrationService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int member_id = Integer.parseInt(request.getParameter("memberid"));
		
		request.setAttribute("member", registrationService.getMemberByMemberID(member_id));		
		request.getRequestDispatcher("/WEB-INF/views/updateregistration.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date todaysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDOB = request.getParameter("dob");
		String strStartDate = request.getParameter("startDate");
		
		try {
			int member_id = Integer.parseInt(request.getParameter("memberid"));
			String firstname = request.getParameter("firstname");
			String lastname = request.getParameter("lastname");
			Date dob = sdf.parse(strDOB);
			String gender = request.getParameter("gender");
			Date startDate = sdf.parse(strStartDate);
			String email = request.getParameter("email");
			String phoneNo = request.getParameter("phoneNo");
			
			Member member = new Member(member_id, startDate, email, phoneNo, firstname, lastname, dob, gender);
			registrationService.updateRegisteredMember(member);

			request.setAttribute("currDate", sdf.format(todaysDate));
			request.setAttribute("members", registrationService.getRegisterMembers());
			request.getRequestDispatcher("/WEB-INF/views/registration.jsp").forward(request, response);
		
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}

}
