<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.nagarro.model.User"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>

<style>
body {
	font-family: arial;
	text-align: center;
}

h3 {
	color: #0066ff;
	display: inline-block;
}

#logoutbtn {
	background-color: black;
	color: white;
	padding: 7px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 10%;
	display: inline-block;
	float: right;
}

#savebtn, #cancelbtn {
	background-color: #ff0066;
	border: none;
	padding: 7px;
	margin: 8px 0;
	cursor: pointer;
	width: 100%;
	color: white;
}

h2 {
	color: #ff0066;
	text-align: left;
	margin:10px;
}

#cancelbtn {
	width: 70%;
	background-color: black;	
}

#container {
	width: 100%;
	text-align: center;
}
form{
text-align: center;
width : 70%;
}
table {
	text-align: left;
	width: 100%;
	border: 2px solid #f2f2f2;
	margin : 10px;
	padding-right : 25px;
	padding-left: 10px;
}

td {
	width: 50%;
}

input[type=text], input[type=date], textarea {
	background-color: #f2f2f2;
	width: 100%;
	border: none;
	margin: 5px;
	padding: 5px;
}
.container{
text-align : left;
margin: 20px;
}
</style>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>


<body>

	<%
		User user = (User) session.getAttribute("user");
	%>
	<h1>Employee Management Utility</h1>
	
	<h3>
		Welcome,<%=user.getUsername()%>!
	</h3>
	<a href="../index.jsp"> <input type="button" value="Logout"
		id="logoutbtn">
	</a>
	<h2>Edit Employees</h2>
		<form:form action="" method="post" modelAttribute="employee">
			<table>
				<tr>
					<td><form:label path = "employeeCode">Employee Code</form:label></td>
					<td><form:input path = "employeeCode" value = "${employee.getEmployeeCode() }" readonly="readonly"/></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td><form:input path="employeeName" value="${employee.getEmployeeName() }"/></td>
				</tr>
				<tr>
					<td>Location</td>
					<td><form:textarea path="location" value="${employee.getLocation() }"/></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><form:input path="email" value="${employee.getEmail() }"/></td>
				</tr>
				<tr>
					<td>DOB(dd-MM-yyyy)</td>
					<td><form:input path="date" value="${employee.getDate() }"/></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" value="Save" name="save" id="savebtn">
					</td>
					
				</tr>
			</table>
		</form:form>
	<div class="container">
		<a href="../home.jsp"> <input type="button" value="Cancel"
			name="Cancel" id="cancelbtn">
		</a>
</div>

</body>
</html>