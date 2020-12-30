package app.vo;

import java.util.Date;

public class ChildDetailsVO {
	private int userId;
	private String fullName;
	private Integer toDoCount;
	private Date latestDate;

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

	public Date getLatestDate() {
		return latestDate;
	}

	public void setLatestDate(Date latestDate) {
		this.latestDate = latestDate;
	}

	@Override
	public String toString() {
		return "ChildDetailsVO [userId=" + userId + ", fullName=" + fullName + ", toDoCount=" + toDoCount
				+ ", latestDate=" + latestDate + "]";
	}
	
}
