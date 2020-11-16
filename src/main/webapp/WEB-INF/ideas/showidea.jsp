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
			
			<h2> Idea Details Below!</h2>
			<div class="idea-details-side">
			
				<h4><strong>Idea: </strong> ${ ideas.name}</h4>
				<h4><strong>Creator:</strong> ${ ideas.ideauser.firstName }</h4>
				
			
							<a href="/ideaspage/${ideas.id}/editselected">Edit Idea!	
							<br>
							<a href="/ideaspage/like/${ideas.id}">Like Idea!
							<br>
							<a href="/ideaspage/unlike/${ideas.id}">Unlike Idea!
		</div>
	</body>
</html>