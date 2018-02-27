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
            <h2>Offer List</h2>
            <h3><a href="offer/add">New Offer</a></h3> 
            <table class="table table-striped">
                <thead>
                    <tr>         
                        <th>No</th>
                        <th>Company</th>
                        <th>Offer Name</th>
                        <th>Desciption</th>
                        <th>Min Salary</th>
                        <th>Max Salary</th>
                        <th>Working Time</th>
                    </tr>
                </thead>
                <tbody>            
                    <c:forEach var="offer" items="${listOffer}" varStatus="status">
                    <tr>              
                        <td>${status.index + 1}</td>
                        <td>${offer.company}</td>
                        <td>${offer.name}</td>
                        <td>${offer.description}</td>
                        <td>${offer.salary_range_min}</td>
                        <td>${offer.salary_range_max}</td>
                        <td>${offer.working_time}</td>
                        <td>
                            <a href="offer/view?id=${offer.id}">View</a>
                        </td>                            
                    </tr>
                    </c:forEach>  
                </tbody>              
            </table>
        </div>
    </body>
</html>