package app.vo;

import java.util.Date;

public class ToDoVO {
	private Integer todoId;
	private Integer userId;
	private String title;
	private String body;
	private Date dueDate;
	private Date createdDate;
	private Date lastUpdatedDate;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	@Override
	public String toString() {
		return "ToDoVO [todoId=" + todoId + ", userId=" + userId + ", title=" + title + ", body=" + body + ", dueDate="
				+ dueDate + ", createdDate=" + createdDate + ", lastUpdatedDate=" + lastUpdatedDate + ", userAvailable="
				+ userAvailable + "]";
	}
}
