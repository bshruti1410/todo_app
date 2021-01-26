package app.vo;

import java.util.Date;

public class ChildDetailsVO {
	private Integer isDisabled;
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

	public Integer getIsDisabled() {
		return isDisabled;
	}

	public void setIsDisabled(Integer isDisabled) {
		this.isDisabled = isDisabled;
	}

	@Override
	public String toString() {
		return "ChildDetailsVO [isDisabled=" + isDisabled + ", userId=" + userId + ", fullName=" + fullName
				+ ", toDoCount=" + toDoCount + ", latestDate=" + latestDate + "]";
	}

}
