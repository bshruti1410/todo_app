<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>logout</title>
	<%@ include file="../resources/NoCacheStore.jsp"%>
	<%@ include file="../resources/js/jslibraries.jsp"%>
	<%@ include file="../resources/css/csslibraries.jsp"%>
	<script type="text/javascript" src="../js/logout.js"></script>
</head>
<body ng-app="logoutApp" ng-controller="logoutController" style="margin: 113px 0px 0px 466px; font-size: 22px; color: red;">
	
	<div ng-if="obj.logout">
		<span ng-bind="obj.msg"></span>
		Please login<a href="/todo_app/jsp/Index.jsp" style="color: red; font-style: italic; font-weight: bold;"> here</a>.
	</div>
	
</body>
</html>