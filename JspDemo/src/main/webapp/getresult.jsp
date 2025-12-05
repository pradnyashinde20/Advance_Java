<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%!public int factorial(int n)
{
int f=1;
for(int i=1;i<=n;i++)
{
	f=f*i;
}
return f;
}%>
<%@include file ="MyHeader.html" %>
<%
String btn=request.getParameter("btn");
int n1=Integer.parseInt(request.getParameter("n1"));
if(btn.equals("add")){
int n2=Integer.parseInt(request.getParameter("n2"));
int ans=0;
ans=n1+n2;
%>
<h2>addition:<%=ans%></h2>
<%}else{
	int fact=factorial(n1);
%>
<h2>factorial:<%=fact %></h2>
<%} %>
<%@include file ="MyFooter.html" %>
</body>
</html>