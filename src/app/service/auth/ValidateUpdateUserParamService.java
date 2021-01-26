package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.ValidateUserParamDao;

public class ValidateUpdateUserParamService {
	
	ValidateUserParamDao dao = new ValidateUserParamDao();
	public boolean validateUserParam(String param, String paramValue, String userName, String phone, String email) throws SQLException {
		
		boolean isAvailable = false;
		try {
			if(paramValue.equals(userName) || paramValue.equals(phone) || paramValue.equals(email)) {
				isAvailable = false;
			} else {
				isAvailable = dao.validateUserParam(param, paramValue);
			}
			
		} catch(SQLException e) {
			System.out.println("Exception occurred in ValidateUpdateUserParamService :: validateUserParam :: " + e);
			throw e;
		}
		return isAvailable;
	}

}
