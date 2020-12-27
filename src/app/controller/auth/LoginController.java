package app.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import app.dao.model.User;
import app.service.auth.LoginService;
import app.vo.UserDetailsVO;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = new User(username, password);
		
		LoginService service = new LoginService();
		try {
			UserDetailsVO userDetailsVO = service.validateCredentials(user);
			
			if (userDetailsVO.getInvalidLoginCount() == 0) {
				session.setAttribute("userId", userDetailsVO.getUserId());
				session.setAttribute("userName", userDetailsVO.getUserName());
				session.setAttribute("fullName", userDetailsVO.getFullName());
				session.setAttribute("phone", userDetailsVO.getPhone());
				session.setAttribute("email", userDetailsVO.getEmail());
				session.setAttribute("role", userDetailsVO.getRole());
				out.print(gson.toJson(userDetailsVO));
	
			} else {
				request.setAttribute("InvalidLoginCount", userDetailsVO.getInvalidLoginCount());
				request.setAttribute("error", "INVALID CREDENTIALS!");
				request.setAttribute("Role", userDetailsVO.getRole());
				out.print(gson.toJson(userDetailsVO));
			}
		} catch (SQLException e) {
			System.out.println("Error Occured in LoginController :: " + e);
			
		}
	}
}