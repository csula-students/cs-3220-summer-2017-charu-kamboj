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
				
				<li><a href="<c:url value='/OrderStatusServlet'/>">Go to Order Status</a></li>
				
			</ul>
			</p>	
			</section>
			</header>
			<br>
			<br>
			<br>
<main>
<table border=2>
       		<tr>
       		<thead>
       			<th>Name</th>
       			<th>Description</th>
       			<th>Image</th>
       			<th>Price</th>
       			<th>Delete</th>
       			</thead>
       		</tr>
       		<tbody>
       		<c:forEach items="${cart}"  var="cartentry">
       		<tr>
       		<td>${cartentry.getName()}</td>
       		<td>${cartentry.getDesc()}</td>
       		<td><img src="${cartentry.getImage()}", width="70px"/></td>
       		<td>${cartentry.getPrice()}</td>
       		<td><a href='../Shopping-cart/delete?id=${cartentry.getId()}'>Remove</a> </td>
       		</tr>
       		</c:forEach>
       		</tbody>
       		</table> 
       		<a href="<c:url value='..\menu.jsp'/>"
						class="button">Go To Main Menu</a>	   
</main>

			

</body>
</html>