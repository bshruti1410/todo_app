package app.controller.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.model.ToDo;
import app.service.todo.ViewToDoService;

@WebServlet("/ViewToDoController")
public class ViewToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		int todoId = Integer.parseInt(request.getParameter("todoId"));
		ToDo todo = null;
		try {
			ViewToDoService service = new ViewToDoService();
			todo = service.getToDoDetails(todoId);
			out.print(todo);
		} catch(SQLException e) {
			System.out.println("Error Occured in ViewToDoController :: doGet :: " + e);
		}
	}

}
