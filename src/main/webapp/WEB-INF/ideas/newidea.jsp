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
		<link rel="stylesheet" href="css/main.css" />
		<meta charset="ISO-8859-1">
	<title>New Idea</title>
</head>
	<body>
	
		<div class="container">
		<h1>Welcome! What is your new idea?</h1>
			<h2>Welcome, ${ user.firstName }</h2>
			<hr/>
			<div class="new-idea float float-left">
			
				<form:form action="/ideaspage/createidea" method="post" modelAttribute="idea">
					<form:hidden value="${ user.id }" path="ideauser"/>
						<div class="form-group">
						<form:label path="inspiration">Idea inspiration</form:label>
						<form:errors path="inspiration"/>
						<form:input class="form-control" path="inspiration"></form:input>
					</div>
					
					<div class="form-group">
						<form:label path="name">Idea Name</form:label>
						<form:errors path="name"/>
						<form:input class="form-control" path="name"></form:input>
					</div>
  				 <button>Click to Create Your New Idea!</button>				    
			</form:form>
			</div>
		
						
					
				</table>
			
								

			</div>
		</div>
	</body>
</html>