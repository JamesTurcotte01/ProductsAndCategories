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
<title>View all categories</title>
</head>
<body>
	<table class="table">	      
	<tr><th scope="col">Category Name</th></tr>
	<c:forEach items="${categorys}" var="cat">
	  <thead>
	  </thead>
	  <tbody>
    <tr>
      <td><a href="/category/${cat.id}"> ${cat.name} </a></td>
    </tr>
    </c:forEach>
  </tbody>
</table>
</body>
</html>