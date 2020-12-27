package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.LoginDao;
import app.dao.model.User;
import app.vo.UserDetailsVO;

public class LoginService {

	public UserDetailsVO validateCredentials(User user) throws SQLException {
		LoginDao dao = new LoginDao();
		UserDetailsVO userDetailsVO = null;
		try {
			userDetailsVO = dao.validateCredentials(user);
		} catch (SQLException e) {
			System.out.println("Error Occured in LoginService :: validateCredentials :: " + e);
			throw e;
		}
		return userDetailsVO;
	}

}