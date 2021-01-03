<%@ page import="app.util.TodoConstants"%>
<%
	if (session.getAttribute("userName") == null) {
		request.setAttribute("error", "Please Login to see the content!");
		RequestDispatcher rd = request.getRequestDispatcher("Index.jsp");
		rd.forward(request, response);
	} else {
		String role = (String) session.getAttribute("role");
%>
	<nav class="navbar navbar-expand-sm " style="background-color: #c5c9ff; font-size: 17px; font-weight: bold;">
	  <a class="navbar-brand" href="HomePage.jsp">Todo App</a>
	  <ul class="navbar-nav">
	  
	    <li class="nav-item dropdown" style="margin-left:32px;">
	      <a class="nav-link dropdown-toggle" id="todo" data-toggle="dropdown" href="#">
	        Todo
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="/todo_app/jsp/CreateUpdateToDo.jsp">Create Todo</a>
	        <hr>
	        <a class="dropdown-item" href="/todo_app/jsp/ViewToDo.jsp">View Todo</a>
	      </div>
	    </li>
    <% if (TodoConstants.Parent.equals(role)) { %>
	    <li class="nav-item dropdown" style="margin-left:32px;">
	      <a class="nav-link dropdown-toggle" id="child" data-toggle="dropdown" href="#">
	        Child
	      </a>
	      <div class="dropdown-menu">
	        <a class="dropdown-item" href="#">Add Child</a>
	        <hr>
	        <a class="dropdown-item" href="/todo_app/jsp/ChildRecord.jsp">View Child</a>
	      </div>
	    </li>
	<% } %>
		<li class="nav-item" style="margin-left: 885px">
		      <a class="nav-link" href="/todo_app/jsp/Logout.jsp"><i class="fa fa-sign-out" aria-hidden="true"></i></a>
		  </li>
	    <li class="nav-item dropdown" style="margin-left: 20px">
	      <a class="nav-link dropdown-toggle" id="account" data-toggle="dropdown" href="#">
	        Profile
	      </a>
	      <div class="dropdown-menu dropdown-menu-right ">
	        <a class="dropdown-item" href="/todo_app/jsp/ChangePassword.jsp">Change Password</a>
	        <hr>
	        <a class="dropdown-item" href="#">Account Details</a>
	      </div>
	    </li>
	  </ul>
	</nav>
<%  } %>