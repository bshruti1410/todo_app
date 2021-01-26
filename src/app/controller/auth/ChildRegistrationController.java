package app.controller.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import app.service.auth.ChildRegistrationService;
import app.util.TodoConstants;
import app.vo.UserDetailsVO;

@WebServlet("/ChildRegistrationController")
public class ChildRegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer parentUserId = (Integer) session.getAttribute("userId");
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();
		String userData = br.readLine();
		JsonElement jsonElement = new JsonParser().parse(userData);
		JsonObject job = jsonElement.getAsJsonObject();
		
		try {
			UserDetailsVO userDetails = new UserDetailsVO();
			userDetails.setUserName(job.get("userName").getAsString());
			userDetails.setPassword(job.get("password").getAsString());
			userDetails.setFullName(job.get("fullName").getAsString());
			userDetails.setAddress(job.get("address").getAsString());
			userDetails.setPhone(job.get("phone").getAsString());
			userDetails.setEmail(job.get("email").getAsString());
			userDetails.setAadhar(job.get("aadhar").getAsString());
			userDetails.setParentId(parentUserId);
			Date dob = new SimpleDateFormat(TodoConstants.MM_dd_yyyy).parse(job.get("dob").getAsString());
			userDetails.setDob(dob);
			
			ChildRegistrationService service = new ChildRegistrationService();
			
			Integer childUserId = service.insertUserDetails(userDetails);
			Integer childId = service.insertChildDetails(childUserId, userDetails);
			out.print(new Gson().toJson(childId));
			
		} catch(SQLException|ParseException e) {
			System.out.println("Exception occurred in ChildRegistrationController :: doPost :: " + e);
		}
		
		
	}

}
