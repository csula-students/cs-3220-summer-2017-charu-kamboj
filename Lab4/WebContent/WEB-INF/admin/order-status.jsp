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
<br>
<table class="center horizontal" border="2">
                <thead>
                    <th >Order Info</th>
                    <th >Customer Info</th>
                    
                    <th >Status</th>
                    <th >Edit?</th>
                    
                </thead>
                <tbody>
                    <c:if test="${orders.size() == 0}">
                        <tr>
                            <td colspan="6"><p>There are no orders!</p></td>
                        </tr>
                    </c:if>
                    <c:forEach items="${orders}" var="order">

                        <tr>
                            <td><p>${order.getId()}</p>
                                </td>
                            <td>${order.getCustomerName()}</td>
                            
                            <td><select>
				<option value="pending">IN PROGRESS</option>
				<option value="in-queue">IN QUEUE</option>
				<option value="completed">COMPLETE</option>
			</select>
                           </td>
                            <td><a href="<c:url value='../admin/orders/edit?id=${order.getId()}' />" class="button">Update</a>
                                </td>
                            
                        </li>
                    </c:forEach> 
                </tbody>
            </table>
</main>			
<footer>
		<h6> @ Copyright CKamboj inc. All rights reserved.
		</h6>
	</footer>
</body>
</html>