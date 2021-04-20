<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
           <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<meta charset="UTF-8">
<title>View product</title>
</head>
<body>
	<h1> ${product.name} categories: </h1>
	<ul class="list-group">
	<c:forEach items="${product.categories}" var="prod">
  		<li class="list-group-item">${prod.name}</li>
	</c:forEach>
	</ul>
	<form action="/product/addCategory" method="POST">
		<input type="hidden" value="${product.id}" name="product_id">
		<select name="category_id">
			<c:forEach items="${category}" var="cat">
				<option value="${cat.id}">
					<c:out value="${cat.name}" />
				</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add category!" />
	</form>
</body>
</html>