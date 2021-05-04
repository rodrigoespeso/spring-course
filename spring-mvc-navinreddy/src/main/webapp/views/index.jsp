<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Spring MVC Navin Reddy</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>
	<nav class="navbar-light bg-light">
		<div class="container-fluid p-2">
						 <p class="text-center" style="font-size: 30px">Alien Manager</p> 
<!-- 			<div class="d-grid gap-2 col-6 mx-auto"> -->
<!-- 				<button class="btn btn-outline-success me-2" type="button">Alien Manager</button> -->
<!-- 			</div> -->
		</div>
	</nav>
	<!--  Forms -->
	<!-- ADDALIEN - POST -->
	<div class="w-25 p-2">
		<h5>Add new Alien object to DB:</h5>
		<form action="addalien" method="post">
			<div class="col">
				<div class="row p-1">
					<div class="col">Alien ID number</div>
					<div class="col">
						<input class="form-control" type="text" name="aid">
					</div>
				</div>
				<div class="row p-1">
					<div class="col">Alien Age number</div>
					<div class="col">
						<input class="form-control" type="text" name="age">
					</div>
				</div>
				<div class="row p-1">
					<div class="col">
						<input class="btn btn-secondary btn-sm form-control" type="submit"
							value="Add">
					</div>
				</div>
			</div>
		</form>
	</div>

	<!-- GETALIEN - GET -->
	<div class="w-25 p-2">
		<h5>Get an Alien object from DB:</h5>
		<form action="getAlien" method="get">
			<div class="col">
				<div class="row p-1">
					<div class="col">
						<label for="alienid" class="col-form-label">Alien Id</label>
					</div>
					<div class="col">
						<input type="text" name="aid">
					</div>
				</div>
				<div class="row p-1">
					<div class="col">
						<input class="btn btn-secondary btn-sm form-control" type="submit"
							value="Get">
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>