<%@page import="com.jensen.entity.User"%>
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
<title>Index</title>

<style type="text/css">



</style>
<%@include file="componnents/mycss.jsp" %>
</head>
<body>

	<%@include file="componnents/navbar.jsp" %>
	
	
	<% User u = (User) session.getAttribute("userobj"); %>
	
	
		<div class="container mt-2">
			<div class="row gy-4">
			
			<%
			
			ProductDaoImp dao = new ProductDaoImp(DBConnection.getconnection());
			
			List<Product> list = dao.getAllProduct();
			for(Product product : list)
			{%>
			
			
					<div class="col-md-3">
						<div class="card">
							<div class="card-body text-center">
								<img alt="lorem" class="card-img-top img-fluid" src="image/<%=product.getImage() %>" style="width: 200px; height: 200px;">
								
								<p><%=product.getName() %></p>
								
								<div class="row ">
								
								<%
								if(u == null)
									
								{%>

									<div class="col">
										<a href="login.jsp" class="btn btn-danger btn-sm">
										<i class="fa-solid fa-cart-plus"></i> Add</a>
									</div>	
								
								<%}else
								{%>
								
									<div class="col">
										<a href="cart?pid=<%=product.getId()%>&&uid=<%=u.getId() %>"
										class="btn btn-danger btn-sm">
										<i class="fa-solid fa-cart-plus"></i> Add</a>
									</div>									
								
								<%}
								
								%>
									

									
									<div class="col">
										<a href="details.jsp?pid=<%=product.getId() %>" class="btn btn-success btn-sm">Details</a>
									</div>
									<div class="col">
										<a href="#" class="btn btn-danger btn-sm">
										<i class="fa-solid fa-dollar-sign"></i>
										<%=product.getPrice() %></a>
									</div>
									
								</div>
								
							</div>
						</div>
					</div>			
			
			<%}
			
			%>			
			
			
			
			</div>
		</div>
	
	<%@include file="componnents/footer.jsp" %>

</body>
</html>