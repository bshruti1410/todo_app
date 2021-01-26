package app.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import app.dao.dbconnection.DBConnection;
import app.vo.UserDetailsVO;

public class ChildRegistrationDao {

	public Integer insertUserDetails(UserDetailsVO userDetails) throws SQLException {
	
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer userId = null;
		try {
			pst = con.prepareStatement("insert into user(user_name, password, phone,email, role)" + "values(?,?,?,?,?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, userDetails.getUserName());
			pst.setString(2, userDetails.getPassword());
			pst.setString(3, userDetails.getPhone());
			pst.setString(4, userDetails.getEmail());
			pst.setString(5, "Child");
			int count = pst.executeUpdate();
			
			if(count>0) {
				rs = pst.getGeneratedKeys();
				if(rs.next())
					userId = rs.getInt(1);
			} else 
				userId = -1;
		} catch(SQLException e) {
			System.out.println("Error occurred in :: ChildRegistrationDao :: insertUserDetails :: " + e);
			throw e; 
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(pst != null)
					pst.close();
				if(con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}
		return userId;
	
	}

	public Integer insertChildDetails(Integer childUserId, UserDetailsVO userDetails) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		Statement st = null;
		ResultSet rs = null;
		ResultSet rst = null;
		Integer childId = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select parent_id from parent where user_id = '"+userDetails.getParentId()+"'");
			if(rs.next()) {
				int parentId = rs.getInt("parent_id");
				pst = con.prepareStatement("insert into child(full_name, address, aadhar, dob, user_id, parent_id)" + "values(?,?,?,?,?,?)", 
						PreparedStatement.RETURN_GENERATED_KEYS);
				pst.setString(1, userDetails.getFullName());
				pst.setString(2, userDetails.getAddress());
				pst.setString(3, userDetails.getAadhar());
				pst.setDate(4, new java.sql.Date(userDetails.getDob().getTime()));
				pst.setInt(5, childUserId);
				pst.setInt(6, parentId);
				int count = pst.executeUpdate();
				if(count>0) {
					rst = pst.getGeneratedKeys();
					if(rst.next())
						childId = rst.getInt(1);
				} else {
					childId = -1;
				}
				
			} else {
				childId = -1;
			}
			
		} catch(SQLException e) {
			System.out.println("Error occurred in :: ChildRegistrationDao :: insertChildDetails :: " + e);
			throw e; 
		} finally {
			try {
				if(rs != null)
					rs.close();
				if(rst != null)
					rst.close();
				if(pst != null)
					pst.close();
				if(con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}
		return childId;
	}
}
