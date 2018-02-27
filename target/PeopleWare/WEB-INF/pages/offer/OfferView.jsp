<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Offer View</title>
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">            
            <h2>Offer ${offer.id}</h2>
            <h3><a href="applicant/add">New Applicant</a></h3>         
            <table class="table table-striped">
                <thead>
                    <tr>             
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Telephone</th>
                        <th>Minimum Salary</th>
                        <th>Working Time</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${offer.company}</td>
                        <td>${offer.name}</td>
                        <td>${offer.description}</td>
                        <td>${offer.salary_range_min}</td>
                        <td>${offer.salary_range_max}</td>
                        <td>${offer.working_time}</td>                
                    </tr>
                </tbody>
            </table>
            <h2>Skills</h2>
            <c:forEach var="skills" items="${skills}" varStatus="status">
                <tr>              
                    <td>${skills.name},</td>                           
                </tr>
            </c:forEach>
            <h2>Degrees</h2>
            <c:forEach var="skills" items="${skills}" varStatus="status">
                <tr>              
                    <td>${skills.name},</td>                           
                </tr>
            </c:forEach>
        </div>
    </body>
</html>