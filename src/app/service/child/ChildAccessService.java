package app.service.child;

import java.sql.SQLException;

import app.dao.child.ChildAccessDao;

public class ChildAccessService {

	public Integer grantRevokeChild(Integer userId, Integer access) throws SQLException {
		ChildAccessDao dao = new ChildAccessDao();
		Integer updateCount = null;
		try {
			if(access == 0) {
				updateCount = dao.grantAccess(userId);
			} else {
				updateCount = dao.revokeAccess(userId);
			}
		} catch(SQLException e) {
			System.out.println("Exception occured in ChildAccessService :: grantRevokeChild :: " + e);
			throw e;
		}
		return updateCount;
	}
	
}
