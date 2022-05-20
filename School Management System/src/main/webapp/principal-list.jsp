<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Principal Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
            crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="https://www.javaguides.net" class="navbar-brand"> Principal
     Management Application </a>
                    </div>
                    

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/principal/list" class="nav-link">Principal</a></li>
                    </ul>
                    
                </nav>
            </header>
            <br>

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List of Principals</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/principal/new" class="btn btn-success">Add
     New Principal</a>
                   
                   
                        <a href = "/School_Management_System/Adminwelcom.jsp">
				<input type=button class="btn btn-success" name="AdminWelcom" value="back"><br>
					 </a>
                   
                
   
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Name</th>
                                <th>Address</th>
                                <th>Birthday</th>
                                <th>Gender</th>
                                <th>Phone</th>
                                <th>Email</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="principal" items="${listPrincipal}">

                                <tr>
                                    <td>
                                        <c:out value="${principal.id}" />
                                    </td>
                                    <td>
                                        <c:out value="${principal.name}" />
                                    </td>
                                    <td>
                                        <c:out value="${principal.address}" />
                                    </td>
                                    <td>
                                        <c:out value="${principal.birthday}" />
                                    </td>
                                    <td>
                                        <c:out value="${principal.gender}" />
                                    </td>
                                    <td>
                                        <c:out value="${principal.phone}" />
                                    </td>
                                    <td>
                                        <c:out value="${principal.email}" />
                                    </td>
                                   
                                   
                                    <td><a href="edit?id=<c:out value='${principal.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${principal.id}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>