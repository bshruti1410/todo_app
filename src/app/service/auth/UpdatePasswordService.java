package app.service.auth;

import java.sql.SQLException;

import app.dao.auth.UpdatePasswordDao;

public class UpdatePasswordService {

	public int updatePassword(Integer userId, String oldPassword, String newPassword) throws SQLException {
		UpdatePasswordDao dao = new UpdatePasswordDao();
		int updateCount = 0;
		try {
			updateCount = dao.updatePassword(userId, oldPassword, newPassword);
		} catch(SQLException e) {
			System.out.println("Exception occurred in UpdatePasswordService :: updatePassword :: " + e);
			throw e;
		}
		return updateCount;
	}

}
