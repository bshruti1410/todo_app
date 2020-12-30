package app.vo;

import java.util.Date;

public class ToDoVO {
	private Integer todoId;
	private String title;
	private String body;
	private Date dueDate;
	private Date createdDate;
	private boolean userAvailable;

	public boolean isUserAvailable() {
		return userAvailable;
	}

	public void setUserAvailable(boolean userAvailable) {
		this.userAvailable = userAvailable;
	}

	public ToDoVO() {

	}

	public ToDoVO(Integer todoId, String title, String body, Date dueDate, Date createdDate) {
		this.todoId = todoId;
		this.title = title;
		this.body = body;
		this.dueDate = dueDate;
		this.createdDate = createdDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Integer getTodoId() {
		return todoId;
	}

	public void setTodoId(Integer todoId) {
		this.todoId = todoId;
	}

	@Override
	public String toString() {
		return "ToDoVO [todoId=" + todoId + ", title=" + title + ", body=" + body + ", dueDate=" + dueDate
				+ ", createdDate=" + createdDate + ", userAvailable=" + userAvailable + "]";
	}
	
}
