package app.dao.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import app.dao.dbconnection.DBConnection;
import app.vo.ToDoVO;
import app.vo.UserDetailsVO;

public class ViewChildToDoDao {

	public UserDetailsVO getChildTodo(Integer userId) throws SQLException {

		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		UserDetailsVO childTodo = new UserDetailsVO();
		 ArrayList<ToDoVO> childTodoList = new ArrayList<ToDoVO>();
		try {
			if(userId != -1) {
				pst = con.prepareStatement("select title,body,due_date from todo where user_id = '" + userId + "'");
				rs = pst.executeQuery();
				if (rs.next()) {
					childTodo.setUserAvailable(true);
					do {
						ToDoVO todo = new ToDoVO();
						todo.setTitle(rs.getString("title"));
						todo.setBody(rs.getString("body"));
						todo.setDueDate(rs.getDate("due_date"));
						childTodoList.add(todo);
					} while(rs.next());
					childTodo.setTodoList(childTodoList);
				} else {
					childTodo.setUserAvailable(false);
				}
			} else {
				childTodo.setUserAvailable(false);
			}
			
		} catch (SQLException e) {
			System.out.print("Error occurred in ViewChildToDoDao :: getChildTodo :: " + e);
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
				System.out.print("Exception occurred in ViewChildToDoDao :: " + e);
			}
		}
		return childTodo;
	}

}
