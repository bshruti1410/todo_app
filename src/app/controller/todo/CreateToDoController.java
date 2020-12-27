package app.controller.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.model.ToDo;
import app.service.todo.CreateToDoService;
import app.util.TodoConstants;

@WebServlet("/CreateToDoController")
public class CreateToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String title = request.getParameter("title");
		String body = request.getParameter("body");
		String dueDate = request.getParameter("dueDate");
		SimpleDateFormat formatter = new SimpleDateFormat(TodoConstants.dd_MM_yyyy);
		Integer userId = (Integer)session.getAttribute("userId");
		
		try {
			CreateToDoService createToDoService = new CreateToDoService();
			           
			ToDo todo = new ToDo();
			todo.setTitle(title);
			todo.setBody(body);
			todo.setUserId(userId);
			todo.setDueDate(formatter.parse(dueDate));
			
			Integer todoId = createToDoService.setTodoDetails(todo);
			
			if(todoId != null) {
				out.print("Successfully created.");
				out.println("<br/>Please Login here <a href=\"jsp/Index.jsp\">Login</a> ");
			} else {
				request.setAttribute("error", "Something went wrong, please re-create carefully.");
				RequestDispatcher rd = request.getRequestDispatcher("jsp/CreateToDo.jsp");
				rd.forward(request, response);
			}
		} catch (SQLException | ParseException e) {
			System.out.println("Error Occured in CreateToDoController :: " + e);
		}
	}

}
