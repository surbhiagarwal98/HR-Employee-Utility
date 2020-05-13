<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
body{
font-family : arial;
text-align: center;
}
table {
	border: 2px solid #f2f2f2;
	margin: auto;
	padding: 20px;
	width: 100%;
	font-weight:bold;
}
input[type=text]{
	background-color: #f2f2f2;
	width : 80%;
	border : none;
	margin: 7px;
	padding:10px;
}
#btn {
	background-color: #ff0066;
  	color: white;
  	padding: 7px;
  	margin: 8px ;
  	border:none;
  	cursor: pointer;
  	width: 30%;
}
</style>
<meta charset="ISO-8859-1">
<title>Reset Password</title>
</head>


<body>
	<h2>Reset your password</h2>
	<form action="reset" method="post">
		<table style = "text-align:center">
			<tr>
				<td>Confirm Username</td>
				<td><input type="text" name="username" class="field" placeholder="Confirm username"><td>
			</tr>
			<tr>
				<td>Enter new password</td>
				<td><input type="text" name="newPassword" placeholder="Enter new password" class="field"></td>
			</tr>
			<tr>
			<td>Confirm Password</td>
			<td><input type="text" name="confirmPassword" placeholder="Confirm new password"class="field"></td>
			</tr>
		</table>
		<input type="submit" value="Submit" id="btn">
	</form>
</body>
</html>