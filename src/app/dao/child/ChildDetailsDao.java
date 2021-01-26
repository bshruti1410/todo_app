package app.dao.child;

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
			rs = st.executeQuery("select u.is_disabled, c.user_id,c.full_name,count(t.todo_id) NumberOfToDoList, max(t.last_updated_date) latestDate from todo t  " + 
					"right join child c on t.user_id=c.user_id  " + 
					"join parent p on p.parent_id=c.parent_id  " + 
					"join user u on u.user_id=c.user_id " + 
					"where p.user_id= '"+userId+"' " + 
					"group by c.user_id");
			
			while (rs.next()) { 
				ChildDetailsVO childDetails = new ChildDetailsVO();
				childDetails.setIsDisabled(rs.getInt("is_disabled"));
				childDetails.setUserId(rs.getInt("user_id"));
				childDetails.setFullName(rs.getString("full_name"));
				childDetails.setToDoCount(rs.getInt("NumberOfToDoList"));
				childDetails.setLatestDate(rs.getDate("latestDate"));
				childToDoList.add(childDetails);
			}
		} catch (SQLException e) {
			System.out.println("Error occured in ChildDetailsDao :: getChildDetails :: " + e);
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
