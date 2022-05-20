<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Student Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
             crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="   " class="navbar-brand"> Student Management Application </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/student/list" class="nav-link">Students</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${student != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${student == null}">
                            <form action="insert" method="post"> 
                        </c:if>

                         <caption>
                            <h2>
                                <c:if test="${student != null}">
                                    Edit Student
                                </c:if>
                                <c:if test="${student == null}">
                                    Add New Student
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${student != null}">
                            <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Student Name</label> <input name="name" type="text" value="<c:out value='${student.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Student Address</label> <input name="address" type="text" value="<c:out value='${student.address}' />" class="form-control" name="address">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Student Birthday</label> <input name="birthday" type="text" value="<c:out value='${student.birthday}' />" class="form-control" name="birthday">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Student Gender</label> <input name="gender" type="text" value="<c:out value='${student.gender}' />" class="form-control" name="gender">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Student Grade</label> <input name="grade" type="text" value="<c:out value='${student.grade}' />" class="form-control" name="grade">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Student Phone</label> <input name="phone" type="text" value="<c:out value='${student.phone}' />" class="form-control" name="phone">
                        </fieldset>
                        

                        <button type="submit" class="btn btn-success">Save</button>
                       </form>
                    </div>
                </div>
            </div>
        </body>

        </html>