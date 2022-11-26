 <%@page import="com.jensen.entity.Order"%>
<%@page import="java.util.List"%>
<%@page import="com.jensen.db.DBConnection"%>
<%@page import="com.jensen.dao.OrderDaoImp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ORDERS</title>
<%@include file="mycss.jsp" %>
</head>
<body>

	<%@include file="navbar.jsp" %>
	
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	
	<div class="container mt-5">
	
		<table class="table">
		  <thead>
		    <tr>
		      <th scope="col">ID</th>
		      <th scope="col">NAME</th>
		      <th scope="col">EMAIL</th>
		      <th scope="col">ADDRESS</th>
		      <th scope="col">PHONE</th>
		      <th scope="col">PRODUCT</th>
		      <th scope="col">PRICE</th>
		    </tr>
		  </thead>
		  <tbody class="table-group-divider">
		  
		  <%
		  
		  OrderDaoImp dao = new OrderDaoImp(DBConnection.getconnection());
		  List<Order> list = dao.getAllOrder();
		  
		  
		  for(Order order : list)
			  
		  {%>

		    <tr>
		      <th scope="row"><%=order.getOrderId() %></th>
		      <td><%=order.getUserName() %></td>
		      <td><%=order.getEmail() %></td>
		      <td><%=order.getFulladd() %></td>
		      <td><%=order.getPhnoe() %></td>
		      <td><%=order.getProductname() %></td>
		      <td><%=order.getPrice() %></td>
	      
		    </tr>
		  
		  <%}
		  
		  %>
		  
		    
		  </tbody>
		</table>
	
	</div>
	
	<%@include file="footer.jsp" %>

</body>
</html>