package app.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutController")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
	
		try {
			session.removeAttribute("userId");
			session.removeAttribute("userName");
			session.removeAttribute("fullName");
			session.removeAttribute("phone");
			session.removeAttribute("email");
			session.removeAttribute("role");
			out.print(1);
		} catch (IllegalStateException e) {
			System.out.println("Exception Occured: LogoutController :: doPost :: " + e);
			out.print(0);
		}
	}

}
