<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="MyHeader.html" %>
<form action="getresult.jsp">
num1:<input type="text" name="n1" id="n1">
num2:<input type="text" name="n2" id="n2">
<button type="submit" name="btn" id="btn" value="add">addition</button>
<button type="submit" name="btn" id="btn" value="fact">factorial</button>

</form>
<%@include file="MyFooter.html" %>
</body>
</html>