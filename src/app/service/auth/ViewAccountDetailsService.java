package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.ViewAccountDetailsDao;
import app.vo.UserDetailsVO;

public class ViewAccountDetailsService {

	public UserDetailsVO getUserDetails(Integer userId) throws SQLException {
		ViewAccountDetailsDao dao = new ViewAccountDetailsDao();
		UserDetailsVO userDetaailsVO = null;
		try {
			userDetaailsVO = dao.getUserDetails(userId);
		} catch(SQLException e) {
			System.out.println("Exception occurred in ViewAccountDetailsService :: getUserDetails :: " + e);
			throw e;
		}
		return userDetaailsVO;
	}

}
