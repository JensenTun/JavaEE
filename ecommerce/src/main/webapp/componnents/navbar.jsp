<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@page isELIgnored="false" %>

<nav class="navbar navbar-expand-lg bg-light">
      <div class="container">
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
          <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
            <li class="nav-item">
              <a class="nav-link active" aria-current="page" href="index.jsp">HOME</a>
            </li>
                        
            <li class="nav-item">
              <a class="nav-link" href="order.jsp">ORDERS</a>
            </li>
            
          </ul>


          <ul class="navbar-nav nav ms-auto">
          
          <c:if test="${not empty userobj}">
          
	            <li class="nav-item">
	              <a class="nav-link" href="login.jsp">${userobj.name}</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="signout">SIGN OUT</a>
	            </li>         
          
          </c:if>
          
 
            
            <c:if test="${empty userobj }">

	            <li class="nav-item">
	              <a class="nav-link" href="login.jsp">SIGN IN</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="register.jsp">REGISTER</a>
	            </li>            
            
            </c:if>

            
          </ul>
          
          
        </div>
      </div>
    </nav>