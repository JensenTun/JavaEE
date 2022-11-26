<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<%@page import="com.jensen.entity.Product"%>
<%@page import="java.util.List"%>
<%@page import="com.jensen.db.DBConnection"%>
<%@page import="com.jensen.dao.ProductDaoImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
<%@include file="mycss.jsp" %>
</head>
<body>

	<%@include file="navbar.jsp" %>
	
	<c:if test="${empty userobj }">
		<c:redirect url="../login.jsp"/>
	</c:if>
	
		<div class="container mt-2">
		
			<div class="row">
			
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">ID</th>
				      <th scope="col">NAME</th>
				      <th scope="col">PRICE</th>
				      <th scope="col">PHOTO</th>
				      <th scope="col">ACTION</th>
				    </tr>
				  </thead>
				  <tbody>
				  
			<%
			
			ProductDaoImp dao = new ProductDaoImp(DBConnection.getconnection());
			
			List<Product> list = dao.getAllProduct();
			for(Product product : list)
			{%>
			

				    <tr>
				      <th scope="row"><%=product.getId() %></th>
				      <td><%=product.getName() %></td>
				      <td><%=product.getPrice() %></td>
				      <td>
				      	<img alt="something" src="../image/<%=product.getImage()%>" style="width: 50px; height: 50px;">
				      </td>
				      <td>
				      	<a href="edit_product.jsp?id=<%=product.getId() %>" class="btn btn-sm btn-primary">Edit</a>
				      	<a href="../deleteProduct?id=<%=product.getId() %>" class="btn btn-sm btn-danger">DELETE</a>
				      </td>
				    </tr>			
			
			<%}
		%>
				  

				    
				  </tbody>
				</table>
			
			</div>
		
		</div>
	
	<%@include file="footer.jsp" %>

</body>
</html>