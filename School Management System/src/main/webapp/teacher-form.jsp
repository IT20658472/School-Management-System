<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>Teacher Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
            integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
             crossorigin="anonymous">
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="   " class="navbar-brand"> Teacher Management Application </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/teacher/list" class="nav-link">Teachers</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${teacher != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${teacher == null}">
                            <form action="insert" method="post"> 
                        </c:if>

                         <caption>
                            <h2>
                                <c:if test="${teacher != null}">
                                    Edit Teacher
                                </c:if>
                                <c:if test="${teacher == null}">
                                    Add New Teacher
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${teacher != null}">
                            <input type="hidden" name="id" value="<c:out value='${teacher.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Teacher Name</label> <input name="name" type="text" value="<c:out value='${teacher.name}' />" class="form-control" name="name" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Teacher Address</label> <input name="address" type="text" value="<c:out value='${teacher.address}' />" class="form-control" name="address">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Teacher Birthday</label> <input name="birthday" type="text" value="<c:out value='${teacher.birthday}' />" class="form-control" name="birthday">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Teacher Gender</label> <input name="gender" type="text" value="<c:out value='${teacher.gender}' />" class="form-control" name="gender">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Teacher Phone</label> <input name="phone" type="text" value="<c:out value='${teacher.phone}' />" class="form-control" name="phone">
                        </fieldset>
                        
                        <fieldset class="form-group">
                            <label>Teacher Email</label> <input name="email" type="text" value="<c:out value='${teacher.email}' />" class="form-control" name="email">
                        </fieldset>
                        

                        <button type="submit" class="btn btn-success">Save</button>
                       </form>
                    </div>
                </div>
            </div>
        </body>

        </html>