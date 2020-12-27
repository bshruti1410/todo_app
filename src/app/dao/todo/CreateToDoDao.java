package app.dao.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.dao.dbconnection.DBConnection;
import app.dao.model.ToDo;

public class CreateToDoDao {

	public Integer setTodoDetails(ToDo todo) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer todoId = null;
		try {
			pst = con.prepareStatement("INSERT into todo(title, body, due_date, created_date, user_id)" + "values(?,?,?,now(),?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, todo.getTitle());
			pst.setString(2, todo.getBody());
			pst.setDate(3, new java.sql.Date(todo.getDueDate().getTime()));
			pst.setInt(4, todo.getUserId());
			int count = pst.executeUpdate();

			rs = pst.getGeneratedKeys();
			if (rs.next())
				todoId = rs.getInt(1);

		} catch (SQLException e) {
			System.out.println("Error Occured in CreateToDoDao :: setTodoDetails :: " + e);
			throw e;
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pst != null)
					pst.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}
		return todoId;
	}

}
