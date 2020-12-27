package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.CheckParentUserNameDao;

public class CheckParentUserNameService {

	public Integer getParentUserName(String parentUserName) throws SQLException{
		CheckParentUserNameDao dao = new CheckParentUserNameDao();
		Integer validateParentUserName = null;
		try {
			validateParentUserName = dao.getParentUserName(parentUserName);
		} catch (SQLException e) {
			System.out.println("Error Occured in CheckParentUserNameService :: getParentUserName :: " + e);
			throw e;
		}
		return validateParentUserName;
	}
	
}
