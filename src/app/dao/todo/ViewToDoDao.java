package app.dao.todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.dao.dbconnection.DBConnection;
import app.dao.model.ToDo;

public class ViewToDoDao {

	public ToDo getToDoDetails(int todoId) throws SQLException {
		Connection con = DBConnection.getConnection();

		ToDo todo = new ToDo();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(" select todo_id,title, body, due_date from todo where todo_id= '" + todoId + "'");
			if (rs.next()) {
				todo.setTodoId(rs.getInt("todo_id"));
				todo.setTitle(rs.getString("title"));
				todo.setBody(rs.getString("body"));
				todo.setDueDate(rs.getDate("due_date"));
			}
		} catch (SQLException e) {
			System.out.println("Error Occured in ViewToDoDao :: getToDoDetails :: " + e);
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (st != null)
					st.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured :: " + e);
			}
		}
		return todo;
	}
}
