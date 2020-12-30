package app.service.todo;

import java.sql.SQLException;

import app.dao.model.ToDo;
import app.dao.todo.ViewToDoDao;

public class ViewToDoService extends ViewToDoListService {

	public ToDo getToDoDetails(int todoId) throws SQLException {
		ToDo todo = null;
		try {
			ViewToDoDao dao = new ViewToDoDao();
			todo = dao.getToDoDetails(todoId);
			
		} catch(SQLException e) {
			System.out.print("Error occured in ViewToDoService :: getToDoDetails :: " + e);
		}
		 return todo;
	}

}
