package app.controller.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import app.service.todo.ViewChildToDoService;
import app.vo.UserDetailsVO;

@WebServlet("/ViewChildToDoController")
public class ViewChildToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		Integer userId = Integer.parseInt(request.getParameter("userId"));
		ViewChildToDoService service = new ViewChildToDoService();
		try {
			UserDetailsVO childTodo = service.getChildTodo(userId);
			out.print(new Gson().toJson(childTodo));
		} catch (SQLException e) {
			System.out.print("Error occurred in ViewChildToDoController :: doGet :: " + e);
		}
	}

}
