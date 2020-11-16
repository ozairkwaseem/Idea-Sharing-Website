<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" 
			rel="stylesheet" 
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" 
			crossorigin="anonymous">
		<link rel="stylesheet" href="/css/main.css" />
		<meta charset="ISO-8859-1">
	<title>Idea</title>
</head>
	<body>
		<div class="container">
			
			<h2> Edit The Below Idea:</h2>
			
			
				<h4><strong>Idea: </strong> ${ ideas.name}</h4>
				<h4><strong>Creator:</strong> ${ ideas.ideauser.firstName }</h4>
				
					
							
					<div class="new-idea float float-left">
			
				<form:form action="/ideaspage/${ideas.id}/edit" method="get" modelAttribute="ideas">
					<form:hidden value="${ ideas.id }" path="ideauser"/>
					
					
					<div class="update-form">
						<form:label path="name">Idea Content</form:label>
						<form:errors path="name"></form:errors>
						<form:input class="form-control" path="name"></form:input>
					</div>
					<br>
  				 <button>Update Idea!</button>				    
			</form:form>
		
			<br>
	
									<form class="delete-form" action="/ideaspage/${ideas.id}/delete" method="get">
										<input type="hidden" name="_method" value="delete" />
										<button>Delete</button>
									</form>	
			</div>
			
		
			
			
			
		</div>
	</body>
</html>