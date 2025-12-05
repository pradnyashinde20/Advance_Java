<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file = "header.html" %>

<%
String btn = request.getParameter("btn");
int n1 = Integer.parseInt(request.getParameter("num1"));
int n2 = Integer.parseInt(request.getParameter("num2"));
int ans =0;
switch(btn){
case "add" :{
	 ans = n1+n2;
	 break;
}
case "sub":{
	 ans = n1-n2;
	 break;
}
case "mul":{
	 ans = n1*n2;
	 break;
}
case "div":{
	 ans = n1/n2;
	 break;
}
}
 %>
<h2> answer is :<%=ans %></h2>
<%@ include file = "footer.html" %>
</body>
</html>