
<html>

<head>
<style>
body {
	text-align: center;
	font-family: arial;
}

.textfield {
	background-color: #f2f2f2;
	width : 100%;
	border : none;
	margin: 7px;
	padding:10px;
}
#labelname{
	width : 50%;
	font-weight: bold;
}
table {
	border: 2px solid #f2f2f2;
	margin: auto;
	padding: 20px;
	width : 60%;
}

#btn {
	background-color: #ff0066;
  	color: white;
  	padding: 14px 20px;
  	margin: 8px 0;
  	border: none;
  	cursor: pointer;
  	width: 60%;
}

h3 {
	color:  #ff0066;
}

</style>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>


<body>
	<h1>Employee Management</h1>
	<h3>HR Login</h3>
	<form action="login" method="post">
		<table>
			<tr>
				<td id= "labelname">Username</td>
				<td><input type="text" name="username" class="textfield" placeholder = "Enter Username"></td>
			</tr>
			<tr>
				<td id= "labelname">Password</td>
				<td><input type="password" class="textfield" name="password" placeholder="Enter Password"></td>
			</tr>
			<tr>
				<td><a href="resetPassword.jsp">Forgotten your password?</a></td>
			</tr>

		</table>
		<input type="submit" value="Login >>" id="btn">
	</form>
</body>

</html>
