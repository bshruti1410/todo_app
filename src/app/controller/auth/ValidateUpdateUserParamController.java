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

import app.service.auth.ValidateUpdateUserParamService;


@WebServlet("/ValidateUpdateUserParamController")
public class ValidateUpdateUserParamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String param = request.getParameter("param");
		String userName = (String)session.getAttribute("userName");
		String phone = (String)session.getAttribute("phone");
		String email = (String)session.getAttribute("email");
		
		PrintWriter out = response.getWriter();
		ValidateUpdateUserParamService service = new ValidateUpdateUserParamService(); 
		boolean isAvailable = false;
		try {
			String paramValue = request.getParameter(param);
			isAvailable = service.validateUserParam(param, paramValue, userName, phone, email);
			out.print(new Gson().toJson(isAvailable));
		} catch(SQLException e) {
			System.out.println("Exception occurred in ValidateUpdateUserParamController :: doGet :: " + e);
		}
		
	}

	
}
