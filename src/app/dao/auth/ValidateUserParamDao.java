package app.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.dao.dbconnection.DBConnection;

public class ValidateUserParamDao {
	
	public boolean validateUserParam(String param, String paramValue) throws SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		boolean isAvailable = false;
		try {
			pst = con.prepareStatement("select * from user where " + param + "='" + paramValue + "'");
			rs = pst.executeQuery();
			if(rs.next()) {
				isAvailable = true;
			} else {
				isAvailable = false;
			}
			
		} catch (SQLException e) {
			System.out.println("Error occured in ValidateUserParamDao :: validateUserParam :: " + e);
			throw e;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
				throw e;
			}
		}
		return isAvailable;
	}
	
}
