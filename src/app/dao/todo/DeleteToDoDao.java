package app.dao.todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import app.dao.dbconnection.DBConnection;

public class DeleteToDoDao {

	public int deleteTodo(int todoId) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		int deleteCount = 0;
		try {
			pst = con.prepareStatement("delete from todo where todo_id=" + todoId);
			deleteCount = pst.executeUpdate();

		} catch(SQLException e) {
			System.out.print("Error occurred in DeleteToDoDao :: deleteTodo :: " + e);
			throw e;
		} finally { 
			try {
				if (pst != null)
					pst.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch(SQLException e) {
				System.out.print("Exception occurred :: " + e);
			}
		}
		return deleteCount;
	}

}
