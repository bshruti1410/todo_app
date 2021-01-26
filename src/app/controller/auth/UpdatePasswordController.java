package app.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.service.auth.UpdatePasswordService;

@WebServlet("/UpdatePasswordController")
public class UpdatePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		Integer userId = (Integer)session.getAttribute("userId");
		PrintWriter out = response.getWriter();
		UpdatePasswordService service = new UpdatePasswordService();
		
		try {
			Integer updateCount = service.updatePassword(userId, oldPassword, newPassword);
			out.print(updateCount);
		} catch(SQLException e) {
			System.out.print("Exception occurred in UpdatePasswordController :: doPost :: " + e);
		}
	}

}
