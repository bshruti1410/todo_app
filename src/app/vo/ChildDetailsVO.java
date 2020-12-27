package app.vo;

public class ChildDetailsVO {
	private int userId;
	private String fullName;
	private Integer toDoCount;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getToDoCount() {
		return toDoCount;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setToDoCount(Integer toDoCount) {
		this.toDoCount = toDoCount;
	}

	@Override
	public String toString() {
		return "ChildDetailsVO [user_id=" + userId + ", fullName=" + fullName + ", toDoCount=" + toDoCount + "]";
	}

}
