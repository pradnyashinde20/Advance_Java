<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>your order is place successfully</h2>
<h3>your bill amount is=<%=request.getParameter("tamt") %>successfully</h3>
<h4>your order will be placed in 2 days</h4>
<h2>thank you for visiting,do visit again!"</h2>
<%---remove session --%>
<%
System.out.println("session is invalid");
		session.invalidate();
%>
<jsp:include page="login.jsp"></jsp:include>
</body>
</html>