package app.dao.auth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.dao.dbconnection.DBConnection;
import app.vo.UserDetailsVO;

public class ViewAccountDetailsDao {

	public UserDetailsVO getUserDetails(Integer userId) throws SQLException {
		Connection con = DBConnection.getConnection();

		UserDetailsVO userDetails = new UserDetailsVO();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select u.user_name, u.role,u.phone,u.email,p.full_name p_full_name, c.full_name c_full_name, "
					+ "p.address p_address,c.address c_address " + 
					"from user u " + 
					"left join child c on u.user_id=c.user_id " + 
					"left join parent p on u.user_id=p.user_id where u.user_id= '"+userId+"'");
			if (rs.next()) {
				userDetails.setUserName(rs.getString("user_name"));
				userDetails.setRole(rs.getString("role"));
				userDetails.setPhone(rs.getString("phone"));
				userDetails.setEmail(rs.getString("email"));
				if(rs.getString("p_full_name") != null)
					userDetails.setFullName(rs.getString("p_full_name"));
				else
					userDetails.setFullName(rs.getString("c_full_name"));
				if(rs.getString("p_address") != null)
					userDetails.setAddress(rs.getString("p_address"));
				else
					userDetails.setAddress(rs.getString("c_address"));
			}
		} catch (SQLException e) {
			System.out.println("Error occured in ViewAccountDetailsDao :: getUserDetails :: " + e);
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured :: " + e);
			}
		}
		return userDetails;
	}

}
