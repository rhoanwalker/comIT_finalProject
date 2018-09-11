package com.comit.web.services;

import com.comit.web.dbutil.DBConnManagerUtil;
import com.comit.web.classes.Member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationService {
	
	// Register a member
	public void RegisterMember(Member member) {
		DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();
	
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
	
		String sql = "INSERT INTO member (first_name, last_name, date_of_birth, gender,"
				+ "start_date, email, phone_no) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, member.getFirstname());
			stmt.setString(2, member.getLastname());
			stmt.setDate(3, new Date(member.getDob().getTime()));
			stmt.setString(4, member.getGender());
			stmt.setDate(5, new Date(member.getMemberStartDate().getTime()));
			stmt.setString(6, member.getMemberEmail());
			stmt.setString(7, member.getMemberPhoneNo());
						
			stmt.execute();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
	}
	
	// get all member registered
	public List<Member> getRegisterMembers() {
		
		DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();		
		List<Member> members = new ArrayList<Member>();
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
		
		String sql = "SELECT * FROM member";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int memberID = rs.getInt("member_id");
				Date startDate = rs.getDate("start_date");
				String email = rs.getString("email");
				String phoneNo = rs.getString("phone_no");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				Date dob = rs.getDate("date_of_birth");
				String gender = rs.getString("gender");
				members.add(new Member(memberID, startDate, email, phoneNo, firstname, lastname, dob, gender));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
		
		return members;
	}
	
	// get member by memberID
	public Member getMemberByMemberID (int member_id) {
		Member member = null;
		
		DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();	
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
		
		String sql = "SELECT * FROM member WHERE member_id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, member_id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				int memberID = rs.getInt("member_id");
				Date startDate = rs.getDate("start_date");
				String email = rs.getString("email");
				String phoneNo = rs.getString("phone_no");
				String firstname = rs.getString("first_name");
				String lastname = rs.getString("last_name");
				Date dob = rs.getDate("date_of_birth");
				String gender = rs.getString("gender");
				member = new Member(memberID, startDate, email, phoneNo, firstname, lastname, dob, gender);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
				
		return member;
	}
	
	// update member registration
	public void updateRegisteredMember(Member member) {
		DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();
		
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
	
		String sql = "UPDATE member SET first_name = ?, last_name = ?, date_of_birth = ?, gender = ?,"
				+ "start_date = ?, email = ?, phone_no = ? WHERE member_id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, member.getFirstname());
			stmt.setString(2, member.getLastname());
			stmt.setDate(3, new Date(member.getDob().getTime()));
			stmt.setString(4, member.getGender());
			stmt.setDate(5, new Date(member.getMemberStartDate().getTime()));
			stmt.setString(6, member.getMemberEmail());
			stmt.setString(7, member.getMemberPhoneNo());
			stmt.setInt(8, member.getMemberID());
						
			stmt.execute();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
	}
	
	// delete member by id
	public void deleteMember(int memberId) {
DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();
		
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
	
		String sql = "DELETE FROM member WHERE member_id = ?";
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setInt(1, memberId);
						
			stmt.execute();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
	}
	

	// method to close open connections
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
