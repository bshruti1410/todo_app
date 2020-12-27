package app.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.auth.CheckParentUserNameService;

@WebServlet("/CheckUserNameController")
public class CheckUserNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String parentUserName = request.getParameter("pUserName");
		
		CheckParentUserNameService service = new CheckParentUserNameService();
		try {
			Integer validateParentUserName = service.getParentUserName(parentUserName);
			out.print(validateParentUserName);
		} catch (SQLException e) {
			System.out.println("Error Occured in CheckUserNameController :: " + e);
			
		}
	}

}
