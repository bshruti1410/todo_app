package app.service.todo;

import java.sql.SQLException;

import app.dao.todo.DeleteToDoDao;

public class DeleteToDoService {

	public int deleteTodo(int todoId) throws SQLException {
		DeleteToDoDao dao = new DeleteToDoDao();
		int deleteCount = 0;
		try {
			deleteCount = dao.deleteTodo(todoId);
		} catch(SQLException e) {
			System.out.print("Error occurred in DeleteToDoSerive :: deleteTodo :: " + e);
			throw e;
		}
		return deleteCount;
	}


}
