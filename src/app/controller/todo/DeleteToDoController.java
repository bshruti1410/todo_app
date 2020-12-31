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

import app.service.todo.DeleteToDoService;

@WebServlet("/DeleteToDoController")
public class DeleteToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int todoId = Integer.parseInt(request.getParameter("todoId"));
		DeleteToDoService service = new DeleteToDoService();
		try {
			int deleteCount = service.deleteTodo(todoId);
			out.print(new Gson().toJson(deleteCount));
		} catch(SQLException e) {
			System.out.print("Error occurred in DeleteToDoController :: doGet :: " + e);
		}
		 
	}

}
