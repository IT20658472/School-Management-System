<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
      <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
		body{
			font-family: Hind SemiBold;
		}
	
		table, th, td {
  			border: 1px solid black;
		}
	</style>
</head>
<body>
<center> 
    <table>
    <h1>Admin Welcome Page</h1>
    <c:forEach var="adm" items= "${admDetails}">
    

	<c:set var="id" value="${adm.id}"/>
	<c:set var="name" value="${adm.name}"/>
	<c:set var="email" value="${adm.email}"/>
	<c:set var="phone" value="${adm.phone}"/>
	
	<tr>
		<td>Admin ID</td>
		<td>${adm.id}</td>
	</tr>
	<tr>
		<td>Admin Name</td>
		<td>${adm.name}</td>
	</tr>
	<tr>
		<td>Admin Email</td>
		<td>${adm.email}</td>
	</tr>
	<tr>
		<td>Admin Phone</td>
		<td>${adm.phone}</td>
	</tr>

    </c:forEach>
    </table>
    

	
	<br>
	
	<a href="<%=request.getContextPath()%>/student/list">
		<input class="cd" type="button" name="student" value="STUDENT">
	</a>
   
    <br>
      <a href="<%=request.getContextPath()%>/teacher/list">
		<input class="cd" type="button" name="teacher" value="TEACHER">
	</a>
   
   <br>
   <a href="<%=request.getContextPath()%>/principal/list">
		<input class="cd" type="button" name="principal" value="PRINCIPAL">
	</a>
   
   
      
      
</center>
     
           
            
		  
</body>
</html>
