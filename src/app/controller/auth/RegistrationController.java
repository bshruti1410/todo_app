package app.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.service.auth.RegistrationService;
import app.util.TodoConstants;
import app.vo.UserDetailsVO;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("userName");
		String password = request.getParameter("password");
		String fullname = request.getParameter("fullName");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String aadhar = request.getParameter("aadhar");
		String dob = request.getParameter("dob");
		String role = request.getParameter("role");
		String pUserName = request.getParameter("pUserName");
		
		UserDetailsVO userDetails = new UserDetailsVO();
		userDetails.setUserName(username);
		userDetails.setPassword(password);
		userDetails.setPhone(phone);
		userDetails.setEmail(email);
		userDetails.setRole(role);
		
		SimpleDateFormat formatter = new SimpleDateFormat(TodoConstants.MM_dd_yyyy);

		RegistrationService registrationservice = new RegistrationService();
		
		try {
			Integer userId = registrationservice.insertUserDetails(userDetails);
			
			if (userId != null) {
				userDetails.setFullname(fullname);
				userDetails.setAddress(address);
				userDetails.setDob(formatter.parse(dob));
				if (TodoConstants.Parent.equals(role)) {
					userDetails.setAadhar(aadhar);
					userDetails.setUserId(userId);
					Integer parentId = registrationservice.insertParentDetails(userDetails);
				} else {
					Integer parentId = registrationservice.getParentId(pUserName);
					userDetails.setUserId(userId);
					userDetails.setParentId(parentId);
					Integer childId = registrationservice.insertChildDetails(userDetails);
				}
				out.print(userDetails.getFullname() + ", you have registered successfully.");
				out.println("<br/>Please Login here <a href=\"jsp/Index.jsp\">Login</a> ");
			} else {
				request.setAttribute("error", "Error Occured");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/RegistrationForm.jsp");
				rd.include(request, response);
			}
		} catch (SQLException | ParseException e) {
			System.out.println("Error Occured in RegistrationController :: doPost :: " + e);
		}
	}

}
