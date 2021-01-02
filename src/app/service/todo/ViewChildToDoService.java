package app.service.todo;

import java.sql.SQLException;
import java.util.ArrayList;

import app.dao.todo.ViewChildToDoDao;
import app.vo.ToDoVO;
import app.vo.UserDetailsVO;

public class ViewChildToDoService {

	public UserDetailsVO getChildTodo(Integer userId) throws SQLException {
		ViewChildToDoDao dao = new ViewChildToDoDao();
		UserDetailsVO childTodo = null;
		try {
			childTodo = dao.getChildTodo(userId);
		} catch (SQLException e) {
			System.out.print("Error occurred in ViewChildToDoService :: getChildTodo :: " + e);
			throw e;
		}
		return childTodo;
	}

}
