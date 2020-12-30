package app.dao.todo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.dao.dbconnection.DBConnection;
import app.vo.ToDoVO;

public class ViewToDoListDao {

	public ArrayList<ToDoVO> viewToDoList(Integer userId) throws SQLException{

		Connection con = DBConnection.getConnection();
		
		ArrayList<ToDoVO> viewToDoList = new ArrayList<ToDoVO>();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery(" select title, body, due_date, created_date from todo where user_id= '" + userId + "'");
			while (rs.next()) {
				ToDoVO todo = new ToDoVO();
				todo.setTitle(rs.getString("title"));
				todo.setBody(rs.getString("body"));
				todo.setDueDate(rs.getDate("due_date"));
				todo.setCreatedDate(rs.getDate("created_date"));
				viewToDoList.add(todo);
			}
		} catch (SQLException e) {
			System.out.println("Error Occured in ViewToDoDao :: viewToDoList :: " + e);
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
				System.out.println("Exception occured: " + e);
			}
		}
		return viewToDoList;
	}


}
