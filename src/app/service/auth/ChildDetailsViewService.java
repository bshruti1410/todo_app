package app.service.auth;

import java.sql.SQLException;
import java.util.ArrayList;

import app.service.dao.ChildDetailsDao;
import app.vo.ChildDetailsVO;

public class ChildDetailsViewService {

	public ArrayList<ChildDetailsVO> getChildDetails(Integer userId) throws SQLException {
		ChildDetailsDao dao = new ChildDetailsDao();
		ArrayList<ChildDetailsVO> childDetailsVO;
		try {
			childDetailsVO = dao.getChildDetails(userId);
		} catch (SQLException e) {
			System.out.println("Error Occured in ChildDetailsViewService :: getChildDetails :: " + e);
			throw e;
		}
		return childDetailsVO;
	}

}
