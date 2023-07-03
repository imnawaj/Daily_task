<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table table-bordered">
<tr>
<th>id</th>
<th scope="col">FirstName</th>
<th scope="col">LastName</th>
<th scope="col">address</th>
<th scope="col">gender</th>
<th scope="col">country</th>
<th scope="col">District</th>
<th scope="col">date</th>
<th scope="col">Pincode</th>
<th scope="col">course</th>
<th scope="col">email</th>
</tr>
<c:forEach var ="emp" items="${users}">
<tr>
<td>${emp.id}</td>
<td>${emp.firstname}</td>
<td>${emp.lastname}</td>
<td>${emp.address }</td>
<td>${emp.gender}</td>
<td>${emp.city}</td>
<td>${emp.state}</td>
<td>${emp.dob}</td>
<td>${emp.pincode}</td>
<td>${emp.course}</td>
<td>${emp.email}</td>
</tr>
</c:forEach>
</table>

</body>
</html>