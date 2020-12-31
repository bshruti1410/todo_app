package app.controller.todo;

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

import app.service.todo.ViewToDoListService;
import app.vo.ToDoVO;

@WebServlet("/ViewToDoListController")
public class ViewToDoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		ViewToDoListService viewToDoService = new ViewToDoListService();
		try {
			ArrayList<ToDoVO> viewToDoList = viewToDoService.viewToDoList(userId);
			out.print(new Gson().toJson(viewToDoList));
		} catch (SQLException e) {
			System.out.println("Error Occured in ViewToDoListController :: " + e);

		}

	}

}
