package app.dao.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	private static Connection con;
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static final String connectionUrl = "jdbc:mysql://localhost:3306/todo_app";
	private static final String username = "root";
	private static final String password = "root";

	public static Connection getConnection() {
		try {
//			if ((con != null && con.isClosed() == true) || con == null) {
//			if (con == null || (con.isClosed() == true)) {
			if (con == null || (con != null && con.isClosed())) {
				Class.forName(driverName);
				con = DriverManager.getConnection(connectionUrl, username, password);
			}
		} catch (Exception e) {
			System.out.println("Exception in Connection creation :: " + e);
		}
		return con;
	}

	public static void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (Exception e) {
			System.out.println("Exception in Connection closure :: " + e);
		}
	}
}
