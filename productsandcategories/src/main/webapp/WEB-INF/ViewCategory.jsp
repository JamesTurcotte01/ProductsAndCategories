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
<title>View category</title>
</head>
<body>
	<h1> ${category.name} products: </h1>
	<ul class="list-group">
	<c:forEach items="${category.products}" var="cat">
  		<li class="list-group-item">${cat.name}</li>
	</c:forEach>
	</ul>
	<form action="/category/addProduct" method="POST">
		<input type="hidden" value="${category.id}" name="category_id">
		<select name="product_id">
			<c:forEach items="${product}" var="prod">
				<option value="${prod.id}">
					<c:out value="${prod.name}" />
				</option>
			</c:forEach>
		</select>
		<input type="submit" value="Add product" />
	</form>
</body>
</html>