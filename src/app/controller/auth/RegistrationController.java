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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import app.service.auth.RegistrationService;
import app.util.TodoConstants;
import app.vo.UserDetailsVO;

@WebServlet("/RegistrationController")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();
		String userData = br.readLine();
		JsonElement jsonElement = new JsonParser().parse(userData);
		JsonObject job = jsonElement.getAsJsonObject();
		
		RegistrationService registrationservice = new RegistrationService();
		
		try {
			UserDetailsVO userDetails = new UserDetailsVO();
			userDetails.setUserName(job.get("userName").getAsString());
			userDetails.setPassword(job.get("password").getAsString());
			userDetails.setPhone(job.get("phone").getAsString());
			userDetails.setEmail(job.get("email").getAsString());
			userDetails.setRole(job.get("role").getAsString());
			Integer userId = registrationservice.insertUserDetails(userDetails);
			
			userDetails.setFullName(job.get("fullName").getAsString());
			userDetails.setAddress(job.get("address").getAsString());
			Date dob = new SimpleDateFormat(TodoConstants.MM_dd_yyyy).parse(job.get("dob").getAsString());
			userDetails.setDob(dob);
			if(userId != null) {
				if (TodoConstants.Parent.equals(job.get("role").getAsString())) {
					userDetails.setAadhar(job.get("aadhar").getAsString());
					userDetails.setUserId(userId);
					Integer parentId = registrationservice.insertParentDetails(userDetails);
				} else {
					Integer parentId = registrationservice.getParentId(job.get("pUserName").getAsString());
					userDetails.setAadhar(job.get("aadhar").getAsString());
					userDetails.setUserId(userId);
					userDetails.setParentId(parentId);
					Integer childId = registrationservice.insertChildDetails(userDetails);
				}
				out.print(new Gson().toJson(userId));
			} else {
				out.print(new Gson().toJson(userId));
			}
		} catch (SQLException | ParseException e) {
			System.out.println("Error Occured in RegistrationController :: doPost :: " + e);
		}
	}

}
