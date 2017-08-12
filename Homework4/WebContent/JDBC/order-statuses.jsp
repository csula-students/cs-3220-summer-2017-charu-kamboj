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
				<li><a href="<c:url value='../admin/orders'/>">Edit Order Status</a></li>
			</ul>
			</p>	
			</section>
			</header>
			<br><br><hr>
<main>
<h3> Manage Orders  </h3>
            
            <table class="center horizontal">
                <thead>
                    <th>Order Info</th>
                    <th>Liquor Requests</th>
                    <th>Status</th>
                    <th>Edit?</th>
                    <th>Delete</th>
                </thead>
                <tbody>
                    <c:if test="${orders.size() == 0}">
                        <tr>
                            <td colspan="5"><p>There are currently no Orders.</p></td>
                        </tr>
                    </c:if>
                    <c:forEach items="${orders}" var="order">
                        <tr>
                            <td>${order.getCustomerName()}<br>
                                ${order.getOrdertime()}
                            </td>
                            
                            <td>
                                <table class="center">
                                    <c:forEach items="${order.getItems()}" var="item">
                                        <tr>
                                            
                                            
                                            <td> ${item.getName()} </td>
                                        </tr>
                                    </c:forEach> 
                                </table>
                            </td>

                            <td>${order.getstatus()}</td>
                            <td><a href="<c:url value='orders/edit?id=${order.getId()}' />" class="button">Edit Status</a>
                                </td>
                            <td><a href="<c:url value='orders/delete?id=${order.getId()}' />" class="button">Delete</a>
                                </td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>


</main>			

</body>
</html>