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
            <h2>Applicants List</h2>
            <h3><a href="applicant/add">New Applicant</a></h3>         
            <table class="table table-striped">
                <thead>
                    <tr>             
                        <th>No</th>
                        <th>Name</th>
                        <th>Surname</th>
                        <th>Email</th>
                        <th>Telephone</th>
                        <th>Minimum Salary</th>
                        <th>Working Time</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="applicant" items="${listApplicant}" varStatus="status">
                    <tr>              
                        <td>${status.index + 1}</td>
                        <td>${applicant.name}</td>
                        <td>${applicant.surname}</td>
                        <td>${applicant.email}</td>
                        <td>${applicant.telephone}</td>
                        <td>${applicant.minimum_salary}</td>
                        <td>${applicant.working_time}</td>
                        <td>
                            <a href="applicant/view?id=${applicant.id}">View</a>
                        </td>                            
                    </tr>
                    </c:forEach>
                </tbody>                
            </table>
        </div>
    </body>
</html>