package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.ChildRegistrationDao;
import app.vo.UserDetailsVO;

public class ChildRegistrationService {

	public int insertUserDetails(UserDetailsVO userDetails) throws SQLException {
		Integer userId= null;
		ChildRegistrationDao dao = new ChildRegistrationDao();
		try {
			userId = dao.insertUserDetails(userDetails);
		} catch(SQLException e) {
			System.out.println("Exception occurred in ChildRegistrationService :: insertUserDetails :: " + e);
			throw e;
		}
		return userId;
	}

	public Integer insertChildDetails(Integer childUserId, UserDetailsVO userDetails) throws SQLException {
		Integer childId= null;
		ChildRegistrationDao dao = new ChildRegistrationDao();
		try {
			childId = dao.insertChildDetails(childUserId, userDetails);
		} catch(SQLException e) {
			System.out.println("Exception occurred in ChildRegistrationService :: insertChildDetails :: " + e);
			throw e;
		}
		return childId;
	}
	
}
