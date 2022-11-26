<%@page import="com.jensen.entity.User"%>
<%@page import="com.jensen.entity.Product"%>
<%@page import="com.jensen.db.DBConnection"%>
<%@page import="com.jensen.dao.ProductDaoImp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Details</title>
<%@include file="componnents/mycss.jsp" %>
</head>
<body>
	<%@include file="componnents/navbar.jsp" %>
	
	<%
	
		User u = (User) session.getAttribute("userobj");
		
	
	%>
	
	
    <div class="container mt-5">
			
      <div class="row justify-content-center">
      
	<%
	
	
		int pid = Integer.parseInt(request.getParameter("pid"));
		ProductDaoImp dao = new ProductDaoImp(DBConnection.getconnection());
		Product p = dao.getProductById(pid);
		
	
	%>      

        <div class="col-md-4">

          <div class="card text-center">
            
            <div class="card-body">
            	<img alt="lorem" src="image/<%=p.getImage() %>" style="width: 200px; height: 200px;">
              <h5 class="card-title"><%=p.getName() %></h5>
              <p class="card-text"><%=p.getDescription() %></p>
            </div>
           <div class="card-body">
            
			<%
				if(u == null)
			{%>            
            
              <a href="login.jsp" class="btn btn-danger btn-sm">
              <i class="fa-solid fa-cart-plus"></i> Add</a>
              
			<a href="#" class="btn btn-danger btn-sm">
			<i class="fa-solid fa-dollar-sign"></i><%=p.getPrice() %></a>              
              
			<%}else
			{%>
			
             <a href="cart?pid=<%=p.getId()%>&&uid=<%=u.getId() %>" class="btn btn-danger btn-sm">Add</a>			
			<a href="#" class="btn btn-danger btn-sm">
			<i class="fa-solid fa-dollar-sign"></i><%=p.getPrice() %></a>
						
			<%}
			%>          
                           
              
            </div>
          </div>          

        </div>

      </div>
		
	</div>
	

	<%@include file="componnents/footer.jsp" %>

</body>
</html>