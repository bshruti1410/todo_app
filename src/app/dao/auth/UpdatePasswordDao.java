package app.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.dao.dbconnection.DBConnection;

public class UpdatePasswordDao {

	public Integer updatePassword(Integer userId, String oldPassword, String newPassword) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		Integer updateCount = null;
		int count = 0;
		try {
			pst = con.prepareStatement("UPDATE user set password = '"+newPassword+ 
										"' where user_id = '"+userId+"' and password = '"+oldPassword+"'");
			count = pst.executeUpdate();
			if(count > 0) {
				updateCount = count;
			} else {
				updateCount = 0;
			}
		} catch(SQLException e) {
			System.out.println("Error occurred in UpdatePasswordDao :: updatePassword :: " + e);
			throw e;
		} finally {
			try {
				if(pst != null)
					pst.close();
				if(con != null)
					DBConnection.closeConnection();
			} catch(SQLException e) {
				System.out.println("Exception occurred in UpdatePasswordDao :: " + e);
			}
		} 
		
		return updateCount;
	}

}
