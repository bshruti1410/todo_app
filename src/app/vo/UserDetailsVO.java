package app.vo;

import java.util.Date;
import java.util.List;

public class UserDetailsVO {
	private Integer userId;
	private String userName;
	private String fullName;
	private String phone;
	private String email;
	private String role;
	private String password;
	private Integer invalidLoginCount;
	private Integer childId;
	private String username;
	private String fullname;
	private String address;
	private String aadhar;
	private Date dob;
	private Integer parentId;
	private List<ToDoVO> todoList;
	private Boolean userAvailable;
	
	
	public Boolean getUserAvailable() {
		return userAvailable;
	}

	public void setUserAvailable(Boolean userAvailable) {
		this.userAvailable = userAvailable;
	}

	public List<ToDoVO> getTodoList() {
		return todoList;
	}

	public void setTodoList(List<ToDoVO> todoList) {
		this.todoList = todoList;
	}

	public Integer getChildId() {
		return childId;
	}

	public void setChildId(Integer childId) {
		this.childId = childId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getInvalidLoginCount() {
		return invalidLoginCount;
	}

	public void setInvalidLoginCount(Integer invalidLoginCount) {
		this.invalidLoginCount = invalidLoginCount;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "UserDetailsVO [userId=" + userId + ", userName=" + userName + ", fullName=" + fullName + ", phone="
				+ phone + ", email=" + email + ", role=" + role + ", password=" + password + ", invalidLoginCount="
				+ invalidLoginCount + ", childId=" + childId + ", username=" + username + ", fullname=" + fullname
				+ ", address=" + address + ", aadhar=" + aadhar + ", dob=" + dob + ", parentId=" + parentId
				+ ", todoList=" + todoList + ", userAvailable=" + userAvailable + "]";
	}

}
