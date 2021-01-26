package app.controller.child;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import app.service.child.ChildAccessService;


@WebServlet("/ChildAccessController")
public class ChildAccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		Integer access = Integer.parseInt(request.getParameter("access"));
		ChildAccessService service = new ChildAccessService();
		try {
			Integer updateCount = service.grantRevokeChild(userId, access);
			out.print(new Gson().toJson(updateCount));
		} catch(SQLException e) {
			System.out.print("Exception occurred in ChildAccessController :: doGet :: " + e);
		}
				
	}

}
