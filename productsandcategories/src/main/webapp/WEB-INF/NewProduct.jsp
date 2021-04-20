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
<title>New products</title>
</head>
<body>
<form:form action="/submit/products" method="POST" modelAttribute="products">
  		<div class="form-group">
   			<form:label path="name">Name: </form:label>
        	<form:errors path="name"/>
    		<form:input type="text" path="name" name="name" class="form-control"/>
  		</div>
 		 <div class="form-group">
    		<form:label path="description">Description: </form:label>
        	<form:errors path="description"/>
    		<form:input type="text" path="description" name="description" class="form-control"/>
  		</div>
  		<div class="form-group">
    		<form:label path="price">Price: </form:label>
        	<form:errors path="price"/>
    		<form:input type="text" path="price" name="price" class="form-control"/>
  		</div>
  		<input type="submit" value="submit" />
  	</form:form>
</body>
</html>