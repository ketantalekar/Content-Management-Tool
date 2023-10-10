<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Sign In</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #333;
	margin: 0;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.container {
	background-color: #E3C773;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	padding: 20px;
	width: 300px;
}

.container h2 {
	text-align: center;
}

table {
	width: 100%;
}

table tr {
	margin-bottom: 10px;
}

table td {
	padding: 10px;
}

.form-group label {
	font-weight: bold;
}

.form-group input {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.form-group button {
	background-color: #007BFF;
	color: #fff;
	border: none;
	border-radius: 4px;
	padding: 10px 20px;
	cursor: pointer;
	margin-top: 10px;
}

.form-group button:hover {
	background-color: #0056b3;
}

.back {
	background-color: #007BFF;
	color: #fff;
	border: none;
	border-radius: 4px;
	padding: 10px 20px;
	cursor: pointer;
	margin-top: 10px;
}

.back:hover {
	background-color: #0056b3;
}
</style>
</head>
<body>
	<div class="container">
		<h2>Sign In</h2>
		<form action="LoginServlet" method="POST">
			<table>
				<tr>
					<td class="form-group"><label for="username">Username:</label>
					</td>
					<td class="form-group"><input type="text" id="username"
						name="uname" required></td>
				</tr>
				<tr>
					<td class="form-group"><label for="password">Password:</label>
					</td>
					<td class="form-group"><input type="password" id="password"
						name="password" required></td>
				</tr>
				<tr>
					<td colspan="2" class="form-group">
						<button type="submit">Login</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
