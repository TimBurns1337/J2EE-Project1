package ProtectionPlan.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class writeQuery {

	Connection conn;
	private ResultSet results;
	
	public writeQuery(Connection c) {
		this.conn = c;
	}
	
	public void insertUser(String uname, String pass, String cell, String email, String name, String address) {
		try {
			String query = "INSERT INTO users "
					+ "(username, password, cell, email, name, address, role)"
					+ " VALUES(?,?,?,?,?,?,?);";
					// can remove role if we want to hard set it then update for user

					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(1, uname); // need to hash
					ps.setString(2, pass); // need to hash
					ps.setString(3, cell);
					ps.setString(4, email);
					ps.setString(5, name);
					ps.setString(6, address);
					ps.setString(7,"User"); // should we hard code the users and update for admin?
					ps.executeUpdate();

			//doRead();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void insertProductToPlan(String uname, String pname, String serial, String pdate, String pid) {
		try {
			String query = "INSERT INTO protectionplan "
					+ "(username, productname, serialnumber, purchasedate, productid)"
					+ "VALUES (?,?,?,?,?);";
					
					int PID = Integer.parseInt(pid);
			
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(2, uname); 
					ps.setString(3, pname);
					ps.setString(4, serial);
					ps.setString(5, pdate); // do date logic here or in view 
					ps.setInt(6, PID);
					ps.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public void insertClaim(String uname, String pid, String cdate, String desc, String issue) {
		try {
			String query = "INSERT INTO claims"
					+ "(username, protectionid, claimdate, description, issue, status)"
					+ "VALUES (?,?,?,?,?,?)";
			
					int PID = Integer.parseInt(pid);
					
					PreparedStatement ps = conn.prepareStatement(query);
					ps.setString(2, uname); 
					ps.setInt(3, PID);
					ps.setString(4, cdate); // setDate(); do date logic in view
					ps.setString(5, desc);
					ps.setString(6, issue);
					ps.setInt(7, 0); // 0 ill be not fixed, update to be fixed by admin
					ps.executeUpdate();

					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
