package app.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import app.dao.dbconnection.DBConnection;

public class CheckParentUserNameDao {

	public int getParentUserName(String parentUserName) throws SQLException{
		
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		int validateParentUserName = 0;
		try {
			pst = con.prepareStatement("SELECT * FROM user where user_name = '"+ parentUserName +"' and role = 'parent'");
			
			rs = pst.executeQuery();
			if(rs.next()) {
				validateParentUserName = 1;
			} else {
				validateParentUserName = 0;
			}

		} catch (SQLException e) {
			System.out.println("Error Occured in CheckParentUserNameDao :: getParentUserName :: " + e);
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
		return validateParentUserName;
	}
}
