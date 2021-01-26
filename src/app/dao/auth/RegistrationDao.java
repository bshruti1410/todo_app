package app.dao.auth;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.dao.dbconnection.DBConnection;
import app.vo.UserDetailsVO;

public class RegistrationDao {
	
	public Integer insertUserDetails(UserDetailsVO user) throws SQLException{
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer userId = null;
		try {
			pst = con.prepareStatement("insert into user(user_name, password, phone,email, role)" + "values(?,?,?,?,?)", 
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, user.getUserName());
			pst.setString(2, user.getPassword());
			pst.setString(3, user.getPhone());
			pst.setString(4, user.getEmail());
			pst.setString(5, user.getRole());
			int count = pst.executeUpdate();
			
			if(count>0) {
				rs = pst.getGeneratedKeys();
				if(rs.next())
					userId = rs.getInt(1);
			} else 
				userId = -1;
				
		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationDao :: insertUserDetails :: " + e);
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

	public Integer insertParentDetails(UserDetailsVO parent) throws SQLException {

		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		Integer parentId = null;
		try {
			pst = con.prepareStatement("insert into parent(full_name, address, aadhar, dob, user_id) " + " values(?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, parent.getFullName());
			pst.setString(2, parent.getAddress());
			pst.setString(3, parent.getAadhar());
			pst.setObject(4, new java.sql.Date(parent.getDob().getTime()));
			pst.setInt(5, parent.getUserId());
			int count = pst.executeUpdate();
			if(count>0) {
				rs = pst.getGeneratedKeys();
				if(rs.next())
					parentId = rs.getInt(1);
			} else {
				parentId = -1;
			}
			

		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationDao :: insertParentDetails :: " + e);
			throw e;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}

		return parentId;
	}

	public Integer insertChildDetails(UserDetailsVO child) throws SQLException {

		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement("insert into child(full_name, address, aadhar, dob, user_id, parent_id) " + " values(?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, child.getFullName());
			pst.setString(2, child.getAddress());
			pst.setString(3, child.getAadhar());
			pst.setDate(4, new java.sql.Date(child.getDob().getTime()));
			pst.setInt(5, child.getUserId());
			pst.setInt(6, child.getParentId());
			int count = pst.executeUpdate();
			if(count>0) {
				rs = pst.getGeneratedKeys();
				if(rs.next())
					child.setChildId(rs.getInt(1));
			} else {
				child.setChildId(-1);
			}
			
			
		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationDao :: insertChildDetails :: " + e);
			throw e;
		} finally {
			try {
				if (pst != null)
					pst.close();
				if (rs != null)
					rs.close();
				if (con != null)
					DBConnection.closeConnection();
			} catch (SQLException e) {
				System.out.println("Exception occured: " + e);
			}
		}
		return child.getChildId();
	}
	
	public Integer getParentId(String pUserName) throws SQLException {
		Connection con = DBConnection.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		Integer parentUserId = null;
		
		try {
			pst = con.prepareStatement("SELECT p.parent_id FROM parent p join user u on u.user_id = p.user_id where u.user_name = '"+ pUserName +"'");
			rs = pst.executeQuery();
			if(rs.next()) {
				parentUserId = rs.getInt("parent_id");
			} else {
				parentUserId = -1;
			}
		
		} catch (SQLException e) {
			System.out.println("Error Occured in RegistrationDao :: getParentId :: " + e);
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
		return parentUserId;
	}
	
}
