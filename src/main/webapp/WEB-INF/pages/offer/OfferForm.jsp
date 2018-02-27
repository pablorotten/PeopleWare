<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>New Offer</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
    		<h2>New Offer</h2>
    		<form:form action="save" method="post" modelAttribute="offer">     
                <form:hidden path="id"/>   		
                <div class="form-group">
                    <label for="company">Company Name:</label>
                    <form:input path="company" type="text" class="form-control" id="name" placeholder="Enter company name" name="name"/>
                </div>              
                <div class="form-group">
                    <label for="name">Offer Name:</label>
                    <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter Name" name="name"/>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <form:input path="description" type="text" class="form-control" id="description" placeholder="Enter description" name="description"/>
                </div>
                <div class="form-group">
                    <label for="salary_range_min">Min Salary:</label>
                    <form:input path="salary_range_min" type="number" class="form-control" id="salary_range_min" placeholder="Min Salary" name="salary_range_min"/>
                </div>
                <div class="form-group">
                    <label for="salary_range_max">Max Salary:</label>
                    <form:input path="salary_range_max" type="number" class="form-control" id="salary_range_max" placeholder="Max Salary" name="salary_range_max"/>
                </div>
                <div class="form-group">
                    <label for="working_time">Working Time: 1 = full-time, 2 = part-time, 3 = both</label>
                    <form:input path="working_time" type="number" class="form-control" id="working_time" placeholder="Working time" name="working_time"/>
                </div>
                
                <div class="form-group">
                    <h2>Degrees</h2>
                    <h3>Select Mandatory degrees</h3>                    
                    <form:checkboxes path="degrees" element="div" items="${degreeList}" itemValue="id" itemLabel="name"/>
                </div>              
                
                <div class="form-group">
                    <h2>Skills</h2>                
                    <h3>Select Mandatory skills</h3>
                    <form:checkboxes path="skills" element="div" items="${skillList}" itemValue="id" itemLabel="name"/>            
                </div>
                
                <button type="submit" class="btn btn-default">Submit</button>
    		</form:form>
    	</div>
    </body>
</html>