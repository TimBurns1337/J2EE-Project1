package ProtectionPlan.dbhelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ProtectionPlan.model.claims;

public class readQuery {

	Connection conn;
	private ResultSet results;
	
	public readQuery(Connection c) {
		this.conn = c;
	}
	
	public void readUserClaims(String username) {
		try {
			String query = "Select * from claims where username =" + username + ";";
			
			PreparedStatement ps = conn.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public String getUserClaimTable() throws SQLException {
		String table = "";
		 table += "<table border=1>"
		 		+ "<tr>"
		 		+ "<th>ID</th>"
		 		+ "<th>Username</th>"
		 		+ "<th>Protection ID</th>"
		 		+ "<th>Claim Date</th>"
		 		+ "<th>Description</th>"
		 		+ "<th>Issue</th>"
		 		+ "<th>Status</th>"
		 		+ "</tr>";
		 
		 while(this.results.next()) {
			 claims claim = new claims();
			 claim.setId(this.results.getInt("id"));
			 claim.setUsername(this.results.getString("username"));
			 claim.setProtectionid(this.results.getInt("protectionid"));
			 claim.setClaimdate(this.results.getString("claimdate"));			 
			 //this.results.getDate("claimdate")
			 claim.setDescription(this.results.getString("description"));
			 claim.setIssue(this.results.getString("issue"));
			 claim.setStatus(this.results.getInt("status"));
			 
			 table += "<tr>";
			 table += "<td>";
			 table += claim.getId();
			 table += "</td>";
			 table += "<td>";
			 table += claim.getUsername();
			 table += "</td>";
			 table += "<td>";
			 table += claim.getProtectionid();
			 table += "</td>";
			 table += "<td>";
			 table += claim.getClaimdate();
			 table += "</td>";
			 table += "<td>";
			 table += claim.getDescription();
			 table += "</td>";		
			 table += "<td>";
			 table += claim.getIssue();
			 table += "</td>";
			 table += "<td>";
			 table += claim.getStatus();
			 table += "</td>";
			 table += "</tr>";
		 }
		 table += "</table>";
		 return table;
	}
	
	
	public void readUsers(String username) {
		try {
			String query = "Select * from users";
			
			PreparedStatement ps = conn.prepareStatement(query);
			this.results = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
}
