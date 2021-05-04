<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Welcome!
	<form action="add.old">
		<h4>Add using Request and Session variables:</h4>
		Enter 1st number: <input type="text" name="num1"><br>
		Enter 2nd number: <input type="text" name="num2"><br> <input
			type="submit">
	</form>
	<form action="add.reqparam">
		<h4>Add using @RequestParam:</h4>
		Enter 1st number: <input type="text" name="num1"><br>
		Enter 2nd number: <input type="text" name="num2"><br> <input
			type="submit">
	</form>
	<form action="add.modelandview">
		<h4>Add using @RequestParam and ModelAndView object:</h4>
		Enter 1st number: <input type="text" name="num1"><br>
		Enter 2nd number: <input type="text" name="num2"><br> <input
			type="submit">
	</form>
	<form action="add.model">
		<h4>Add using @RequestParam and Model object:</h4>
		Enter 1st number: <input type="text" name="num1"><br>
		Enter 2nd number: <input type="text" name="num2"><br> <input
			type="submit">
	</form>
	<form action="addalien">
		<h4>Add Alien object:</h4>
		Enter Alien Id number: <input type="text" name="id"><br>
		Enter Alien Age number: <input type="text" name="age"><br>
		<input type="submit" value="Send">
	</form>
	<form action="addalien.modelattr" method = "post">
		<h4>Add Alien object using @ModelAttribute:</h4>
		Enter Alien Id number: <input type="text" name="id"><br>
		Enter Alien Age number: <input type="text" name="age"><br>
		<input type="submit" value="Send">
	</form>
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