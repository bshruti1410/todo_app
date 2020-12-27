package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.RegistrationDao;
import app.vo.UserDetailsVO;

public class RegistrationService {

	Integer userID = null;
	Integer parentId = null;
	Integer childId = null;

	public Integer insertUserDetails(UserDetailsVO user) throws SQLException {
		RegistrationDao dao = new RegistrationDao();
		try {
			userID = dao.insertUserDetails(user);
		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationService :: insertUserDetails :: " + e);
			throw e;
		}
		return userID;
	}

	public Integer insertParentDetails(UserDetailsVO parent) throws SQLException {
		RegistrationDao dao = new RegistrationDao();
		try {
			parentId = dao.insertParentDetails(parent);
		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationService :: insertParentDetails :: " + e);
			throw e;
		}
		
		return parentId;

	}
	
	
	public Integer insertChildDetails(UserDetailsVO child) throws SQLException {
		RegistrationDao dao = new RegistrationDao();
		try {
			childId = dao.insertChildDetails(child);
		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationService :: insertChildDetails :: " + e);
			throw e;
		}
		return childId;

	}

	public Integer getParentId(String pUserName) throws SQLException {
		RegistrationDao dao = new RegistrationDao();
		try {
			parentId = dao.getParentId(pUserName);
		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationService :: getParentId :: " + e);
			throw e;
		}
		return parentId;
	}

}
