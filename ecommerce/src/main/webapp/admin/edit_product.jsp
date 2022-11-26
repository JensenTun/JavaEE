<%@page import="com.jensen.entity.Product"%>
<%@page import="com.jensen.db.DBConnection"%>
<%@page import="com.jensen.dao.ProductDaoImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EDIT</title>
<%@include file="mycss.jsp" %>
</head>
<body>

<c:if test="${empty userobj }">
	<c:redirect url="../login.jsp"/>
</c:if>

	<%@include file="navbar.jsp" %>
	
		<div class="container mt-5">
		
			<div class="row">
			
				<div class="col-md-4 offset-md-4">
					<div class="card">
						<div class="card-body">
							<h4 class="text-center">EDIT PRODUCT</h4>
							
							<%
							
								int id = Integer.parseInt(request.getParameter("id"));
								ProductDaoImp dao = new ProductDaoImp(DBConnection.getconnection());
								Product product = dao.getProductById(id);
							
							%>
							
								<form action="../updateProduct" method="post" enctype="multipart/form-data">
								
								<input type="hidden" name="id" value="<%=product.getId()%>">
							
								<div class="form-group">
									<label>Product Name</label>
									<input type="text" class="form-control" name="name" value="<%=product.getName()%>">
								</div>
								
								
								<div class="form-group">
									<label>Price</label>
									<input type="number" class="form-control" name="price" value="<%=product.getPrice()%>">
								</div>
								
								
								<div class="form-group">
									<label>Description</label>
									<textarea rows="4" cols="" class="form-control" name="desc"><%=product.getDescription() %></textarea>
								</div>								
								

								
								<div class="form-group">
									<label>Upload Photo</label>
									<input type="file" class="form-control" name="img">
									<img alt="some" src="../image/<%=product.getImage()%>" style="width: 200px; height: 200px;">
								</div>
								
								
	
								<div class="form-group pt-2">
									 <input type="submit" class="btn btn-info form-control" value="UPDATE">
								</div>
															
							</form>
							
						</div>
					</div>
				</div>
			
			</div>
		
		</div>
	
	<%@include file="footer.jsp" %>

</body>
</html>