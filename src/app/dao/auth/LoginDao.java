package app.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.dao.dbconnection.DBConnection;
import app.dao.model.User;
import app.vo.UserDetailsVO;

public class LoginDao {

	public UserDetailsVO validateCredentials(User user) throws SQLException {
		Connection con = DBConnection.getConnection();
		Statement st = null;
		PreparedStatement pst = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;

		UserDetailsVO userDetailsVO = new UserDetailsVO();
		try {
			st = con.createStatement();
			rs1 = st.executeQuery("SELECT role, invalid_login_count from user where user_name = '" + user.getUserName() + "'");
			if (rs1.next()) {
				int invalidCount = rs1.getInt("invalid_login_count");
				String role = rs1.getString("role");
				
				rs2 = st.executeQuery("SELECT u.user_id, p.full_name p_full_name,c.full_name c_full_name,u.role,u.email,u.phone " + 
						"FROM user u left join parent p on u.user_id=p.user_id " + 
						"left join child c on u.user_id=c.user_id where u.user_name = '" + user.getUserName() + "' and u.password = '" + user.getPassword() + "'");
				if(rs2.next()) {
					pst = con.prepareStatement("UPDATE user set invalid_login_count=0 where user_name = '" + user.getUserName() + "'");
					int updateCount = pst.executeUpdate();
					if (updateCount > 0) {
						userDetailsVO.setUserId(rs2.getInt("user_id"));
						userDetailsVO.setUserName(user.getUserName());
						if (rs2.getString("p_full_name") != null)
							userDetailsVO.setFullName(rs2.getString("p_full_name"));
						else
							userDetailsVO.setFullName(rs2.getString("c_full_name"));
						
						userDetailsVO.setPhone(rs2.getString("phone"));
						userDetailsVO.setRole(rs2.getString("role"));
						userDetailsVO.setEmail(rs2.getString("email"));
						userDetailsVO.setInvalidLoginCount(0);
					}
				} else {
					pst = con.prepareStatement("UPDATE user set invalid_login_count=invalid_login_count+1 where user_name = '" + user.getUserName() + "'");
					int updateCount = pst.executeUpdate();
					if (updateCount > 0) {
						userDetailsVO.setInvalidLoginCount(invalidCount + 1);
						userDetailsVO.setRole(role);
					}
						
				}
			} else {
				userDetailsVO.setInvalidLoginCount(-1);
			}
		} catch (SQLException e) {
			System.out.println("Error Occured in LoginDao :: validateCredentials :: " + e);
			throw e;
		} finally {
			try {
				if (st != null)
					st.close();
				if (pst != null)
					pst.close();
				if (rs1 != null)
					rs1.close();
				if (rs2 != null)
					rs2.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}

		return userDetailsVO;
	}
}
