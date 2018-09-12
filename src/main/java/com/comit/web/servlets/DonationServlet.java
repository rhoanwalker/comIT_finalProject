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

import com.comit.web.classes.Donation;
import com.comit.web.services.DonationService;

@WebServlet("/donations")
public class DonationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DonationService donationService = new DonationService();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date todaysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		request.setAttribute("currDate", sdf.format(todaysDate));
		request.setAttribute("donors", donationService.getMemberDonors());
		request.getRequestDispatcher("/WEB-INF/views/donations.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Date todaysDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String strDonationDate = request.getParameter("donationDate");
		
		
		try {
			String donation_type = request.getParameter("donationType");
			int donor_id = Integer.parseInt(request.getParameter("donorId"));
			Date donation_date = sdf.parse(strDonationDate);
			Double donation_amount = Double.parseDouble(request.getParameter("donationAmount"));
		
			Donation donation = new Donation (donation_type, donor_id, donation_date, donation_amount);
			donationService.AddMemberDonation(donation);
			
			request.setAttribute("successMsg", "Donation added successfully!");
			request.setAttribute("currDate", sdf.format(todaysDate));
			request.setAttribute("donors", donationService.getMemberDonors());
			request.getRequestDispatcher("/WEB-INF/views/donations.jsp").forward(request, response);
	
		} catch (ParseException pe) {
			pe.printStackTrace();
		}
	}

}
