<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ADD</title>
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
							<h4 class="text-center">ADD PRODUCT</h4>
							
								<form action="../addProduct" method="post" enctype="multipart/form-data">
							
								<div class="form-group">
									<label>Product Name</label>
									<input type="text" class="form-control" name="name">
								</div>
								
								
								<div class="form-group">
									<label>Price</label>
									<input type="number" class="form-control" name="price">
								</div>
								
								
								<div class="form-group">
									<label>Description</label>
									<textarea rows="4" cols="" class="form-control" name="desc"></textarea>
								</div>								
								

								
								<div class="form-group">
									<label>Upload Photo</label>
									<input type="file" class="form-control" name="img">
								</div>
								
								
	
								<div class="form-group pt-2">
									 <input type="submit" class="btn btn-info form-control" value="ADD">
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