<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.List, com.demo.beans.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
List<Product> plist = (List<Product>)request.getAttribute("plist");
%>
<form action="placeorder.jsp">
 <button type="submit" name ="order" id="order" >Place Order</button>
</form>
<%
for(Product p:plist){%>
<div>
<form action="addToCart" method="post">
Product id : <%=p.getPid() %><br/>
Product name : <%=p.getPname() %><br/>
Product price : <%=p.getPrice() %><br/>
<input type="hidden" name="pid" id ="pid" value="<%=p.getPid() %>">
<input type="hidden" name="pname" id ="pname" value="<%=p.getPname() %>">
<input type="hidden" name="price" id ="price" value="<%=p.getPrice() %>">
Quantity : <input type="text" name="qty" id="qty"><br/>
<button type="submit" name="btn" id="btn">Add To Cart</button>
</form> 
</div>
	
<%}
%>
</body>
</html>