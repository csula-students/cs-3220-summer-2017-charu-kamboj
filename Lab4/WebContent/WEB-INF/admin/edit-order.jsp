<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="adminHeader.tld" prefix= "cs3220"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smoke House Cafe</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/app.css' />">
</head>
<body>
	<header >
			<section class="container" >
			<p>
			<cs3220:AdminHeader/>
			
			
			<ul class="hyperlinks">
				<li><a href="<c:url value='../admin/orders'/>">Go to Order Status</a></li>
			</ul>
			</p>	
			</section>
			</header>

<main>
     <br>
     <br>       
            
            <p>Order Edited for:</p>

            <p>${orderToEdit.getCustomerName()} </p>
            
            <p>Order status has been changed</p>
               
                <a href="<c:url value='../orders' />" class="button">Go back to Orders.</a>
           


        </main>

</body>
</html>