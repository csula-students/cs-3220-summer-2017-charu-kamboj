<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib uri="adminHeader.tld" prefix= "cs3220"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smoke House Cafe</title>
<link rel="stylesheet" type="text/css" href="<c:url value='../../app.css' />">
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
<h2>Create your own food</h2>
<form method="post">
                Food Name:<br>
                <input type="text" name="name" value="Pancakes"><br>
                Item Price:<br>
                <input type="number" step="0.01" name="price" value="5.47"><br><br>
                <input type="submit" value="Add Food to Inventory!">
</form>
</main>
<footer>
		<h6> @ Copyright CKamboj inc. All rights reserved.
		</h6>
	</footer>

</body>
</html>