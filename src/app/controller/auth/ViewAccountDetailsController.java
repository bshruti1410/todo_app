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

import com.google.gson.Gson;

import app.service.auth.ViewAccountDetailsService;
import app.vo.UserDetailsVO;

@WebServlet("/ViewAccountDetailsController")
public class ViewAccountDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter(); 
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		ViewAccountDetailsService service = new ViewAccountDetailsService();
		UserDetailsVO userDetailsVO = null;
		try {
			userDetailsVO = service.getUserDetails(userId);
			out.print(new Gson().toJson(userDetailsVO));
		} catch(SQLException e) {
			System.out.println("Exception occurred in ViewAccountDetailsController :: doGet :: " + e);
		}
	}

}
