package com.comit.web.services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.comit.web.classes.Donation;
import com.comit.web.classes.Member;
import com.comit.web.dbutil.DBConnManagerUtil;

public class DonationService {
	
	public List<Member> getMemberDonors() {
		
	DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();		
	List<Member> members = new ArrayList<Member>();
	Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
	
	String sql = "SELECT member_id, first_name, last_name FROM member";
	
	try {
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int memberID = rs.getInt("member_id");
			String firstname = rs.getString("first_name");
			String lastname = rs.getString("last_name");
			members.add(new Member(memberID, firstname, lastname));
		}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
		
		return members;
	}
	
	public void AddMemberDonation(Donation donation) {
		DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();
	
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
	
		String sql = "INSERT INTO donations (don_type, donor_id, don_date, don_amount) VALUES (?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, donation.getType());
			stmt.setInt(2, donation.getDonor());
			stmt.setDate(3, new Date(donation.getDonDate().getTime()));
			stmt.setDouble(4, donation.getAmount());
						
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
	}

	//method to close open connections
	private void CloseConnection(Connection conn) {
		try {			
			if (conn != null) {
				conn.close();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
