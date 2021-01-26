package app.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.dao.dbconnection.DBConnection;
import app.vo.UserDetailsVO;

public class UpdateAccountDetailsDao {

	public Integer updateUserDetails(UserDetailsVO userDetailsVO) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer updateUserDetailsCount = null;
		int updateCount = 0;
		try {
			
			pst = con.prepareStatement("update user u " + 
					"left join child c on u.user_id=c.user_id " + 
					"left join parent p on u.user_id=p.user_id " + 
					"set u.user_name = '"+ userDetailsVO.getUserName()+
					"', p.address= '"+userDetailsVO.getAddress()+
					"', c.address= '"+userDetailsVO.getAddress()+
					"', u.phone = '"+userDetailsVO.getPhone()+
					"', u.email = '"+userDetailsVO.getEmail()+
					"', p.full_name = '"+userDetailsVO.getFullName()+
					"', c.full_name = '"+userDetailsVO.getFullName()+
					"' where u.user_id = '"+userDetailsVO.getUserId()+"'");
			
			updateCount = pst.executeUpdate();
			if (updateCount > 0)
				updateUserDetailsCount = updateCount;
			else
				updateUserDetailsCount = 0;
		
		} catch (SQLException e) {
			
			System.out.println("Error occured in UpdateAccountDetailsDao :: updateUserDetails :: " + e);
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
			}
		}
		return updateUserDetailsCount;
	}

}
