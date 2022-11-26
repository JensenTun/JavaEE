
<%@page import="java.util.List"%>
<%@page import="com.jensen.entity.Cart"%>
<%@page import="com.jensen.db.DBConnection"%>
<%@page import="com.jensen.dao.CartDAOImp"%>
<%@page import="com.jensen.entity.User"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
<%@include file="componnents/mycss.jsp" %>
</head>
<body>

<%@include file="componnents/navbar.jsp" %>


	<c:if test="${ empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>
	</c:if>
	
	<c:if test="${not empty succMsg }">
		<div class="alert alert-success text-center" role="alert">
			${succMsg }
		</div>
		<c:remove var="succMsg" scope="session"/>
	</c:if>
	
	<c:if test="${not empty failedMsg }">
		<div class="alert alert-danger text-center" role="alert">
			${failedMsg }
		</div>
		<c:remove var="failedMsg" scope="session"/>
	</c:if>	
		

	<div class="container mt-2">
	
		<div class="row">
		
			<div class="col-md-6">				
				
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success">Your Selected Item</h3>
						<table class="table">
						  <thead>
						    <tr>
						      <th scope="col">Product Name</th>
						      <th scope="col">Price</th>
						      <th scope="col">Action</th>
						    </tr>
						  </thead>
						  <tbody>
						  
						  <%
						  	User u =(User) session.getAttribute("userobj");
						  	CartDAOImp dao = new CartDAOImp(DBConnection.getconnection());
						  	List<Cart> cart = dao.getProductByUser(u.getId());
						  	Double totalPrice = 0.00;
						  	for (Cart c: cart)
						  	{
								totalPrice = c.getTotalPrice();						  	
						  	%>
						  	
							  	<tr>
							      <th scope="row"><%=c.getProductName() %></th>
							      <td><%=c.getPrice() %></td>
							      <td>
							      <a href="removeOrder?pid=<%=c.getPid() %>&&uid=<%=c.getUserId() %>&&cid=<%=c.getCid() %>"
							      class="btn btn-sm btn-danger">renmove</a>
							      </td>
							    </tr>
						  	
						  	<%}
						  %>
						  
						  <tr>
						  	<td>totalPrice</td>
						  	<td></td>
						  	<td></td>
						  	<td><%=totalPrice %></td>
						  </tr>
						    
						  </tbody>
						</table>						
					</div>
				</div>
			</div>
			
			<div class="col-md-6">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-white">Your Details for Order</h3>
						<form action="orderProduct" method="post">
						
							<input type="hidden" name="id" value="${userobj.id }">
						
							<div class="row">
								<div class="form-group col-md-6">
									<label>Name</label>
									<input class="form-control" type="text" name="username"
									value="${userobj.name }" readonly="readonly">
								</div>
								<div class="form-group col-md-6">
									<label>Email</label>
									<input class="form-control" type="text" name="useremail"
									value="${userobj.email }" readonly="readonly">
								</div>							
							</div>
							
							<div class="row">
								<div class="form-group col-md-6">
									<label>Phone number</label>
									<input class="form-control" type="number" name="userphone"
									value="${userobj.phno }" readonly="readonly">
								</div>
								<div class="form-group col-md-6">
									<label>Address</label>
									<input class="form-control" type="text" name="useraddress"required>
								</div>							
							</div>
						
							<div class="row">
								
								<div class="form-group col-md-6">
									<label>City</label>
									<input class="form-control" type="text" value="" name="usercity" required>
								</div>
								
								<div class="form-group col-md-6">
									<label>State</label>
									<input class="form-control" type="text" name="usersate" required>
								</div>
																						
							</div>					
					
					
							<div class="text-center pt-3">
								<button class="btn btn-warning">Order Now</button>
								<a href="index.jsp" class="btn btn-success">Continue Shopping</a>
							</div>					

						
						</form>
					</div>
				</div>
			
			</div>
		</div>
		
	</div>

<%@include file="componnents/footer.jsp" %>

</body>
</html>