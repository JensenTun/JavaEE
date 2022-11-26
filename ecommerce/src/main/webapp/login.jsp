<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
<%@include file="componnents/mycss.jsp" %>
</head>
<body>

	<%@include file="componnents/navbar.jsp" %>
	
	
	<div class="container pt-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<h4 class="text-center">Login</h4>
						
						
						<form action="login" method="post">
						  
						  <div class="form-group">
						    <label for="exampleInputEmail1">Email address</label>
						    <input type="email" class="form-control" id="exampleInputEmail1" 
						    aria-describedby="emailHelp" name="email" required="required">
						  </div>
						  
						  <div class="form-group">
						    <label for="exampleInputPassword1">Password</label>
						    <input type="password" class="form-control"
						    id="exampleInputPassword1" name="password" required="required">
						  </div>
						  <div class="form-group pt-2">
						    <input type="submit" class="btn btn-info form-control" value="Login">
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