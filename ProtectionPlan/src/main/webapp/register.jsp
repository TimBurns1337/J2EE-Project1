<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
	<div class="container">
		<form method="POST">
			
				<label for="username">Username</label> <input type="text"
					 id="user" name="user" placeholder="Enter Username"
					required />
			
				<label for="password">Password</label> <input type="password"
					 id="pass" name="pass"
					placeholder="Enter Password" />
			
				<label for="cell">Cell Number </label> <input type="text"
					 id="cell" name="cell"
					placeholder="Enter Cell Number" />
			
				<label for="email">Email</label> <input type="text"
					 id="email" name="email"
					placeholder="Enter Email"  />
				
				<label for="name">Name</label> <input type="text"
					 id="name" name="name"
					placeholder="Enter Name"  />
				
				<label for="address">Address</label> <textarea name="address" 
				id= "address" placeholder="Enter Address"> </textarea>
				
				<label for="role">Role</label>
				<select name="role" id="role">
  					<option value="admin">Admin</option>
  					<option value="user">User</option>
 				</select>
				<button type="submit">Register</button>
			
		</form>
	</div>
</body>
</html>