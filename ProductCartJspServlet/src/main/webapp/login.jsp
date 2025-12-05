<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
Username: <input type="text" name="uname" id="uname"></br>
Password: <input type="text" name="pass" id="pass"></br>
<button type="submit" name="login" id="login">Login</button>
</form>
<a href="register.html">Register Me </a>
<a href="forgot.html">Forgot Password </a>
</body>
</html>