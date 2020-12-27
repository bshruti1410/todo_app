package app.controller.todo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.service.todo.ViewToDoService;
import app.vo.ToDoVO;

@WebServlet("/ViewToDoController")
public class ViewToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer userId = (Integer) session.getAttribute("userId");

		ViewToDoService viewToDoService = new ViewToDoService();
		try {
			ArrayList<ToDoVO> viewToDoList = viewToDoService.viewToDoList(userId);

			Iterator<ToDoVO> itr = viewToDoList.iterator();
			ToDoVO todo;
			while (itr.hasNext()) {
				todo = (ToDoVO) itr.next();
				out.println(todo.getTitle());
				out.println(todo.getBody());
				out.println(todo.getDueDate());
				out.println(todo.getCreatedDate());
			}

			System.out.println(viewToDoList);
		} catch (SQLException e) {
			System.out.println("Error Occured in ViewToDoController :: " + e);

		}

	}

}
