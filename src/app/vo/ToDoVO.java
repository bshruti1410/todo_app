package app.vo;

import java.util.Date;

public class ToDoVO {
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

	public ToDoVO(String title, String body, Date dueDate, Date createdDate) {

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

	@Override
	public String toString() {
		return "ToDoVO [title=" + title + ", body=" + body + ", dueDate=" + dueDate + ", createdDate=" + createdDate
				+ ", userAvailable=" + userAvailable + "]";
	}

}
