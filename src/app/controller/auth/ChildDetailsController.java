package app.controller.auth;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import app.service.auth.ChildDetailsViewService;
import app.vo.ChildDetailsVO;

@WebServlet("/ChildDetailsController")
public class ChildDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gson gson = new Gson();
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		Integer userId = (Integer)session.getAttribute("userId");
		
		ChildDetailsViewService childDetailService = new ChildDetailsViewService();
		ArrayList<ChildDetailsVO> childDetails;
		try {
			childDetails  = childDetailService.getChildDetails(userId);
			out.print(gson.toJson(childDetails));
		} catch (SQLException e) {
			System.out.println("Error Occured in ChildDetailsController :: " + e);
		}
	}
}
