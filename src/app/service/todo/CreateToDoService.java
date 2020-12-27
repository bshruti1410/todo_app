package app.service.todo;

import java.sql.SQLException;

import app.dao.model.ToDo;
import app.dao.todo.CreateToDoDao;

public class CreateToDoService {

	public Integer setTodoDetails(ToDo todo) throws SQLException {
		CreateToDoDao dao = new CreateToDoDao();
		Integer todoId = null;
		
		try {
			todoId = dao.setTodoDetails(todo);
		} catch (SQLException e) {
			System.out.println("Error Occured in CreateToDoService :: setTodoDetails :: " + e);
			throw e;
		}
		
		return todoId;
	}

}
