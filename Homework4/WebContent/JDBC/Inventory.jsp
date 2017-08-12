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
	<main> <section class="main">
	<h1 class="h2">Smoke House-Admin</h1>
	<table class="cart-table" border="1" bordercolor="#228B22"
		cellspacing="0" cellpadding="4">
		<thead>
			<tr>
				<th>Item</th>
				<th>image</th>
				<th>Description</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="item">
				<tr>
					<td> ${item.getName() }</td>
					<td><img src="<c:url value='${item.getImage()}'/>" width="100" height="100"> <br></td>
					<td>${item.getDesc() }</td>
                    <td>${item.getPrice()}</td>
                    <td><a href="<c:url value='EditFoodServlet?id=${item.getId() }'/>"class="button">Edit</a>
					<a href="<c:url value='DeleteFoodServlet?id=${item.getId() }'/>"class="button">Delete</a></td>
						
				</tr>
			</c:forEach>

		</tbody>
	</table>

<a href="AddFoodServlet">Create new food</a>
</br>
</br>
<a href="MenuServlet">go to menu</a>					
	</section> </main>
	<footer>
		<h6> @ Copyright CKamboj inc. All rights reserved.
		</h6>
	</footer>

</body>
</html>