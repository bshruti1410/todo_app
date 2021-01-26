package app.dao.child;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.dao.dbconnection.DBConnection;

public class ChildAccessDao {

	public Integer revokeAccess(Integer userId) throws SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		Integer updateCount = null;
		int revoke = 0;
		try {
			pst = con.prepareStatement("update user set is_disabled=1,invalid_login_count=max_invalid_login where user_id= '"+userId+"'");
			revoke = pst.executeUpdate();
			if (revoke > 0)
				updateCount = revoke;
			else
				updateCount = -1;
		} catch (SQLException e) {
			System.out.println("Error Occured in ChildAccessDao :: revokeAccess :: " + e);
			throw e;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}
		return updateCount;
	}

	public Integer grantAccess(Integer userId) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		Integer updateCount = null;
		int grant = 0;
		try {
			pst = con.prepareStatement("update user set invalid_login_count=0, is_disabled=0 where user_id= '"+userId+"'");
			grant = pst.executeUpdate();
			if (grant > 0)
				updateCount = grant;
			else
				updateCount = -1;
		} catch (SQLException e) {
			System.out.println("Error Occured in ChildAccessDao :: grantAccess :: " + e);
			throw e;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}
		return updateCount;
	}

}
