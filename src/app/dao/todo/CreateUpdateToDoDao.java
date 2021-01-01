package app.dao.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import app.dao.dbconnection.DBConnection;
import app.dao.model.ToDo;

public class CreateUpdateToDoDao {

	public Integer updateTodo(ToDo todo) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer todoId = null;
		int count = 0;
		try {
			pst = con.prepareStatement("update todo set title = '" + todo.getTitle() + "', body = '" + todo.getBody()
					+ "', due_date = '" + new java.sql.Date(todo.getDueDate().getTime()) + "', last_updated_date = '"
					+ new java.sql.Date(new Date().getTime()) + "' where todo_id = " + todo.getTodoId());
			count = pst.executeUpdate();
			if (count > 0)
				todoId = todo.getTodoId();
			else
				todoId = -1;
		} catch (SQLException e) {
			System.out.println("Error Occured in CreateUpdateToDoDao :: updateTodo :: " + e);
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
	
	public Integer createTodo(ToDo todo) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer todoId = null;
		int count = 0;
		try {
			pst = con.prepareStatement("INSERT into todo(title, body, due_date, user_id)" + "values(?,?,?,?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, todo.getTitle());
			pst.setString(2, todo.getBody());
			pst.setObject(3, new java.sql.Date(todo.getDueDate().getTime()));
			pst.setInt(4, todo.getUserId());
			count = pst.executeUpdate();
			if (count > 0) {
				rs = pst.getGeneratedKeys();
				if (rs.next())
					todoId = rs.getInt(1);
			} else
				todoId = -1;

		} catch (SQLException e) {
			System.out.println("Error Occured in CreateUpdateToDoDao :: createTodo :: " + e);
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