package com.comit.web.services;

import com.comit.web.classes.User;
import com.comit.web.dbutil.DBConnManagerUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserValidationService {
	
	public boolean isUserValid(String username, String password){
		
		DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();
		boolean isUserValid = false;
		
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
		
		String sql = "SELECT * FROM tbl_user WHERE uname = ? AND pword = ?"; //using statement in parameters
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			stmt.setString(2, password);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				isUserValid = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
		
		return isUserValid;
	}

	private void CloseConnection(Connection conn) {
		try {			
			if (conn != null) {
				conn.close();
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public User getUserByUsername(String username) {
		
		DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();
		User user = null;
		
		Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
		
		String sql = "SELECT  u.uid, u.member_id, u.uname, u.pword, u.utype, m.first_name, m.last_name\r\n" + 
				"FROM tbl_user u INNER JOIN member m\r\n" + 
				"ON u.member_id = m.member_id\r\n" + 
				"AND u.uname = ?"; 
		
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, username);
			
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				int uid = rs.getInt("uid");
				int memberid = rs.getInt("member_id");
				String uname = rs.getString("uname");
				String pword = rs.getString("pword");
				String utype = rs.getString("utype");
				String fname = rs.getString("first_name");
				String lname = rs.getString("last_name");
				
				user = new User(uid, memberid, uname, pword, utype, fname, lname);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {		
			CloseConnection(conn);
		}
		
		return user;
	}
}
