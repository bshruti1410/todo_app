package app.service.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import app.dao.dbconnection.DBConnection;
import app.vo.ChildDetailsVO;

public class ChildDetailsDao {

	public ArrayList<ChildDetailsVO> getChildDetails(Integer userId) throws SQLException {
		ArrayList<ChildDetailsVO> childToDoList = new ArrayList<ChildDetailsVO>();
		Connection con = DBConnection.getConnection();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select c.user_id,c.full_name,count(t.todo_id) NumberOfToDoList from todo t " + 
					"right join child c on t.user_id=c.user_id " + 
					"join parent p on p.parent_id=c.parent_id " + 
					"where p.user_id= '"+userId+"' " + 
					"group by c.user_id");
			
			if (rs.next()) {
				do {
					ChildDetailsVO childDetails = new ChildDetailsVO();
					childDetails.setUserId(rs.getInt("user_id"));
					childDetails.setFullName(rs.getString("full_name"));
					childDetails.setToDoCount(rs.getInt("NumberOfToDoList"));
					childToDoList.add(childDetails);
				} while(rs.next());	
			}
		} catch (SQLException e) {
			System.out.println("Error Occured in ChildDetailsDao :: getChildDetails :: " + e);
			throw e;
		} finally {
			try {
				if (st != null)
					st.close();
				if (rs != null)
					rs.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}
		return childToDoList;
	}

}
