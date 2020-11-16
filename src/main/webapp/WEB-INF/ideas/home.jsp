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
	<title>Great Ideas!!</title>
</head>
	<body>
	
		<div class="container">
		<h1>Great Ideas Home Page</h1>
		
			<h2>Welcome, ${ user.firstName }</h2>
			<hr />
			<div class="new-idea float float-left">
		<table class="table table-dark table-hover">
<thead>
<tr>
<td>Ideas</td>
<td>Idea Creator  </td>
<td>Likes </td>
<td>Like! :) </td>
<td>Unlike! :( </td>					
					</thead>
					<tbody>
					<c:forEach items="${ ideas }" var="ideas">
						<tr>
							<td><a href="/ideaspage/${ideas.id}">${ ideas.name }</a></td>
							<td> ${ideas.ideauser.firstName}</td>
						
							<td>
								${ ideas.likers.size() }
							</td>
							
							<td>
								<a href="/ideaspage/like/${ideas.id}">Like 
							</td>
							
													
							<td>
															<a href="/ideaspage/unlike/${ideas.id}">Unlike 
							</td>
							
							
						</tr>
					</c:forEach>
					</tbody>
				</table>

</table>

		
			
		<a href="/ideaspage/createideaselected">Create a New Idea		

			</div>
		</div>
	</body>
</html>