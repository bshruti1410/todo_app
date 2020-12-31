package app.service.child;

import java.sql.SQLException;
import java.util.ArrayList;

import app.dao.child.ChildDetailsDao;
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
