package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.UpdateAccountDetailsDao;
import app.vo.UserDetailsVO;

public class UpdateAccountDetailsService {

	public Integer updateUserDetails(UserDetailsVO userDetailsVO) throws SQLException {
		UpdateAccountDetailsDao dao = new UpdateAccountDetailsDao();
		Integer updateCount = null;
		try {
			updateCount = dao.updateUserDetails(userDetailsVO);
		}catch(SQLException e) {
			System.out.println("Exception occurred in UpdateAccountDetailsService :: updateUserDetails :: " + e);
			throw e;
		}
		return updateCount;
	}

}
