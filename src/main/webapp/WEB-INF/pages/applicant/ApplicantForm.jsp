<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>New Applicant</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2>New Applicant</h2>
    		<form:form action="save" method="post" modelAttribute="applicant">
       			<form:hidden path="id"/>
                <div class="form-group">
                    <label for="name">Name:</label>
                    <form:input path="name" type="text" class="form-control" id="name" placeholder="Enter Name" name="name"/>
                </div>
                <div class="form-group">
                    <label for="surname">Surname:</label>
                    <form:input path="surname" type="text" class="form-control" id="surname" placeholder="Enter Surname" name="surname"/>
                </div>
                <div class="form-group">
                    <label for="email">Email:</label>
                    <form:input path="email" type="email" class="form-control" id="email" placeholder="Enter email" name="email"/>
                </div>
                <div class="form-group">
                    <label for="telephone">Telephone:</label>
                    <form:input path="telephone" type="text" class="form-control" id="telephone" placeholder="Enter Telephone" name="telephone"/>
                </div>
                <div class="form-group">
                    <label for="minimum_salary">Minimum Salary</label>
                    <form:input path="minimum_salary" type="number" class="form-control" id="minimum_salary" placeholder="Enter Minimum Salary" name="minimum_salary"/>
                </div>
                <div class="form-group">
                    <label for="working_time">Working Time: 1 = full-time, 2 = part-time, 3 = both</label>
                    <form:input path="working_time" type="number" class="form-control" id="working_time" placeholder="Working time" name="working_time"/>
                </div>
                                   
                <div class="form-group">
                    <h2>Degrees</h2>
                    <h3>Select your degrees</h3>
                 
                    <form:checkboxes path="degrees" element="div" items="${degreeList}" itemValue="id" itemLabel="name"/>
                </div>   
                     
                <div class="form-group">  
                    <h2>Skills</h2>                
                    <h3>Select your skills</h3>
                    <h5>Don't forget to select your level skill: 1 is the minimum and 5 the highest</h5>
                        <form:checkboxes path="skills" element="div" items="${skillList}" itemValue="id" itemLabel="name"/>             
                </div>
                
                <button type="submit" class="btn btn-default">Submit</button>
    		</form:form>
    	</div>
    </body>
</html>