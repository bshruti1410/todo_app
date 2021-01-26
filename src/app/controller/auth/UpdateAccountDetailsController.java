package app.controller.auth;

import java.io.BufferedReader;
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
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import app.service.auth.UpdateAccountDetailsService;
import app.vo.UserDetailsVO;

@WebServlet("/UpdateAccountDetailsController")
public class UpdateAccountDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();
		String userDetails = br.readLine();
		JsonElement jsonElement = new JsonParser().parse(userDetails);
		JsonObject job = jsonElement.getAsJsonObject();

		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");
		
		try {
			UpdateAccountDetailsService service = new UpdateAccountDetailsService();
			UserDetailsVO userDetailsVO = new UserDetailsVO();
			userDetailsVO.setUserId(userId);
			userDetailsVO.setAddress(job.get("address").getAsString());
			userDetailsVO.setFullName(job.get("fullName").getAsString());
			userDetailsVO.setUserName(job.get("userName").getAsString());
			userDetailsVO.setPhone(job.get("phone").getAsString());
			userDetailsVO.setEmail(job.get("email").getAsString());
			Integer updateCount = service.updateUserDetails(userDetailsVO);
			out.print(new Gson().toJson(updateCount));
		} catch(SQLException e) {
			System.out.println("Exception occurred in UpdateAccountDetailsController :: doPost:: " + e);
		}
		
	}

}
