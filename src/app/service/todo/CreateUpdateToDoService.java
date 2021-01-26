package app.service.todo;

import java.sql.SQLException;

import app.dao.model.ToDo;
import app.dao.todo.CreateUpdateToDoDao;

public class CreateUpdateToDoService {

	public Integer createUpdateTodo(ToDo todo) throws SQLException {
		CreateUpdateToDoDao dao = new CreateUpdateToDoDao();
		Integer todoId = null;
		try {
			if (todo.getTodoId() != -1) {
				todoId = dao.updateTodo(todo);
			} else {
				todoId = dao.createTodo(todo);
			}
		} catch (SQLException e) {
			System.out.println("Error Occured in CreateUpdateToDoService :: createUpdateTodo :: " + e);
			throw e;
		}

		return todoId;
	}

}
