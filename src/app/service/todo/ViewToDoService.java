package app.service.todo;

import java.sql.SQLException;
import java.util.ArrayList;

import app.dao.todo.ViewToDoDao;
import app.vo.ToDoVO;

public class ViewToDoService {
	
	public ArrayList<ToDoVO> viewToDoList(Integer UserId) throws SQLException {
		ViewToDoDao dao = new ViewToDoDao();
		ArrayList<ToDoVO> viewToDoList = null;
		try {
			viewToDoList = dao.viewToDoList(UserId);
		} catch (SQLException e) {
			System.out.println("Error Occured in ViewToDoService :: viewToDoList :: " + e);
			throw e;
		}
		return viewToDoList;
	}
	
}
