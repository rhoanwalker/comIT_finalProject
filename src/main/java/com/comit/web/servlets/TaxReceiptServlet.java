package com.comit.web.servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.comit.web.classes.User;
import com.comit.web.services.TaxReceiptService;


@WebServlet("/taxreceipt")
public class TaxReceiptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaxReceiptService taxReceiptService = new TaxReceiptService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date todaysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		User sessionUser = new User();
		sessionUser = (User) request.getSession(false).getAttribute("user");
		
		//int member_id = (int) request.getSession(false).getAttribute("user.memberId");
		int member_id = sessionUser.getMemberId();
		int tax_year = 2018;
		String donation_type = "Tithes";
		
		request.setAttribute("currDate", sdf.format(todaysDate));
		request.setAttribute("taxReceipt", taxReceiptService.getMemberTaxReceipt(member_id, tax_year, donation_type));
		request.getRequestDispatcher("/WEB-INF/views/taxreceipt.jsp").forward(request, response);
	}

}
