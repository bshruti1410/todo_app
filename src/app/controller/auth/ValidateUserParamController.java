package app.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import app.service.auth.ValidateUserParamService;

@WebServlet("/ValidateUserParamController")
public class ValidateUserParamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String param = request.getParameter("param");
		PrintWriter out = response.getWriter();
		ValidateUserParamService service = new ValidateUserParamService(); 
		try {
			boolean isAvailable = false;
			String paramValue = request.getParameter(param);
			isAvailable = service.validateUserParam(param, paramValue);
			out.print(new Gson().toJson(isAvailable));
			
		} catch(SQLException e) {
			System.out.println("Exception occurred in ValidateUserParamController :: doGet :: " + e);
		}
		
	}

}
