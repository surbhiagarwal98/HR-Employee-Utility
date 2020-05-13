<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.nagarro.model.User"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {
	font-family: arial;
}

h2 {
	text-align: center;
}

table {
	border: 1px solid black;
	width: 100%;
	border-collapse: collapse;
}

th, td {
	border-collapse: collapse;
	border: 2px solid #f2f2f2;
	padding: 9px;
}

td:nth-child(odd) {
	background-color: #e6f7ff;
}

td:nth-child(even) {
	background-color: #ccefff;
}

#empcode {
	width: 10%;
}

#empname {
	width: 20%;
}

#location {
	width: 25%;
}

#email {
	width: 25%
}

#date {
	width: 15%;
}

#action {
	width: 5%;
}

#btn {
	background-color: #ff0066;
	color: white;
	padding: 7px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 30%;
	float: right;
}

h3 {
	color: #0066ff;
	display: inline-block;
}

form[action=logout] {
	display: inline-block;
	float: right;
	width: 20%;
}

#logoutbtn {
	background-color: black;
	color: white;
	padding: 7px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
}

#showbtn {
	border: none;
	color: white;
	background-color: #0066ff;
	padding: 7px;
	margin: 8px;
	cursor: pointer;
}

#uploadform {
	background-color: #ff0066;
	color: white;
	padding: 7px;
	margin: 8px 0;
	width: 32%;
}
#uploadbtn, #browse{
	background-color:#ff0066;
	color:white;
	border:none;
	cursor : pointer;
}
</style>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>


<body>
	<%
		User user = (User) session.getAttribute("user");
	%>
	<h2>Employee Details</h2>
	<h3>
		Welcome,
		<%=user.getUsername()%>!
	</h3>
	<form action="logout" method="post">
		<input type="submit" value="Logout" id="logoutbtn">
	</form>


	<form id="uploadform" action="employees/uploadCSV" method="post" enctype="multipart/form-data">
		<input type="file" id="browse" name="file"> 
		<input type="submit" value="Upload" id="uploadbtn">
	</form>
	<form action="employees/downloadCSV" method="post">
		<input type="submit" value="Download Employee Details" id="btn">
	</form>



	<form action="employees" method="get">
		<input type="submit" value="Show all employees" id="showbtn">
	</form>

	<table name="employees">
		<tr>
			<th id="code" name="employeeCode">Code</th>
			<th id="name" name="employeeName">Name</th>
			<th id="location" name="location">Location</th>
			<th id="email" name="email">Email</th>
			<th id="date" name="date">Date</th>
			<th id="action" name="action">Action</th>
		</tr>

		<c:forEach items="${employees}" var="employee">
			<tr>
				<td>${employee.getEmployeeCode()}</td>
				<td>${employee.getEmployeeName()}</td>
				<td>${employee.getLocation()}</td>
				<td>${employee.getEmail()}</td>
				<td>${employee.getDate()}</td>
				<td>
					<form action="employees/${employee.getEmployeeCode()}" method="get">
						<input type="submit" value="Edit"
							style="border: none; cursor: pointer">
					</form>

				</td>

			</tr>
		</c:forEach>

	</table>

</body>
</html>