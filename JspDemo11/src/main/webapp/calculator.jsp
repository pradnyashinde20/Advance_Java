<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@ includefile = "header.html" %>
<form action="calculate.jsp">
enter num1: <input type="text" name="num1" value="num1"><br/>
enter num2: <input type="text" name="num2" value="num2"><br/>
<button type="submit" name="btn" id="btn" value="add"> addition</button>
<button type="submit" name="btn" id="btn" value="sub"> substraction</button>
<button type="submit" name="btn" id="btn" value="mul"> multiplication</button>
<button type="submit" name="btn" id="btn" value="div"> division</button>
</form>
<%@ includefile = "footer.html" %>
</body>
</html>