<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Applicant Manager Home</title>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">            
            <h2>Applicant ${applicant.id}</h2>
            <h3><a href="add">New Applicant</a></h3>         
            <table class="table table-striped">
                <thead>
                    <tr>  
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Telephone</th>
                        <th>Minimum Salary</th>
                        <th>Working Time</th>
                    <tr>              
                        <td>${applicant.name}</td>
                        <td>${applicant.surname}</td>
                        <td>${applicant.email}</td>
                        <td>${applicant.telephone}</td>
                        <td>${applicant.minimum_salary}</td>
                        <td>${applicant.working_time}</td>                 
                    </tr>
                </thead>
            </table>
            <h3>Skills</h3>
            <c:forEach var="skills" items="${skills}" varStatus="status">
                <tr>              
                    <td>${skills.name},</td>                           
                </tr>
            </c:forEach>
            <h3>Degrees</h3>
            <c:forEach var="skills" items="${skills}" varStatus="status">
                <tr>              
                    <td>${skills.name},</td>                           
                </tr>
            </c:forEach>
        </div>
    </body>
</html>