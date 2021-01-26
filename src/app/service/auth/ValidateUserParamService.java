package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.ValidateUserParamDao;

public class ValidateUserParamService {
	ValidateUserParamDao dao = new ValidateUserParamDao();
	
	public boolean validateUserParam(String param, String paramValue) throws SQLException {
		boolean isAvailable = false;
		try {
			isAvailable = dao.validateUserParam(param, paramValue);
		} catch(SQLException e) {
			System.out.println("Exception occurred in ValidateUserParamService :: validateParam :: " + e);
			throw e;
		}
		return isAvailable;
	}
}
