package app.controller.todo;

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

import app.dao.model.ToDo;
import app.service.todo.CreateUpdateToDoService;
import app.util.TodoConstants;

@WebServlet("/CreateUpdateToDoController")
public class CreateUpdateToDoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		BufferedReader br = request.getReader();
		String todoData = br.readLine();
		JsonElement jsonElement = new JsonParser().parse(todoData);
		JsonObject job = jsonElement.getAsJsonObject();

		HttpSession session = request.getSession();

		Integer userId = (Integer) session.getAttribute("userId");

		try {
			CreateUpdateToDoService createUpdateToDoService = new CreateUpdateToDoService();

			ToDo todo = new ToDo();
			todo.setTitle(job.get("title").getAsString());
			todo.setBody(job.get("body").getAsString());
			todo.setUserId(userId);
			todo.setTodoId(job.get("todoId").getAsInt());
			Date dueDate = new SimpleDateFormat(TodoConstants.MM_dd_yyyy).parse(job.get("dueDate").getAsString());
			todo.setDueDate(dueDate);
			Integer todoId = createUpdateToDoService.createUpdateTodo(todo);
			out.print(new Gson().toJson(todoId));
		} catch (SQLException | ParseException e) {
			System.out.println("Error Occured in CreateUpdateToDoController :: doPost :: " + e);
		}
	}

}
