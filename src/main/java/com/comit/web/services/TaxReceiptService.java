package com.comit.web.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.comit.web.classes.TaxReceipt;
import com.comit.web.dbutil.DBConnManagerUtil;

public class TaxReceiptService {

	public TaxReceipt getMemberTaxReceipt(int member_id, int tax_year, String donation_type) {
		
			TaxReceipt taxReceipt = null;
			
			DBConnManagerUtil dbConnUtil = new DBConnManagerUtil();	
			Connection conn = dbConnUtil.getConnection("jdbc:mysql://localhost:3306/buc_db", "javauser", "Java@Com1t");
			
			String sql = "SELECT d.donor_id, m.first_name, m.last_name, SUM(d.don_amount) as don_amount, YEAR(d.don_date) as tax_year\r\n" + 
					"FROM donations d INNER JOIN member m\r\n" + 
					"ON d.donor_id = m.member_id\r\n" + 
					"AND d.donor_id = ?\r\n" + 
					"AND YEAR(d.don_date) = ?\r\n" + 
					"AND d.don_type = ?";
			
			try {
				PreparedStatement stmt = conn.prepareStatement(sql);
				stmt.setInt(1, member_id);
				stmt.setInt(2, tax_year);
				stmt.setString(3, donation_type);
				ResultSet rs = stmt.executeQuery();
				
				if(rs.next()) {
					int memberID = rs.getInt("donor_id");
					String memberFName = rs.getString("first_name");
					String memberLName = rs.getString("last_name");
					Double memberAmount = rs.getDouble("don_amount");
					int taxYear = rs.getInt("tax_year");
					
					taxReceipt = new TaxReceipt(memberID, memberFName, memberLName, memberAmount, taxYear);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {		
				CloseConnection(conn);
			}
		
		return taxReceipt;
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
