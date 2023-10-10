<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>CMS - Content Management System</title>
<style type="text/css">
/* Reset some default styles */
body, h1, h2, p, ul, li {
	margin: 0;
	padding: 0;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	color: #333;
	line-height: 1.6;
}

.container1 {
	display: flex;
	margin: 0 auto;
	padding: 20px;
}

.container2 {
	max-width: 1200px;
	margin: 0 auto;
	padding: 20px;
}

header {
	background-color: #333;
	color: #fff;
}

nav {
	display: flex;
	justify-content: space-between;
	align-items: center;
}

.logo h1 {
	font-size: 28px;
	margin: 0px;
}

.nav-links {
	list-style: none;
	margin-left: 1250px;
}

.nav-links li {
	display: inline;
	margin-left: 20px;
}

.nav-links a {
	text-decoration: none;
	color: #fff;
	font-weight: bold;
	font-size: 18px;
}

.main {
	padding: 20px;
}

h2 {
	font-size: 24px;
	margin-bottom: 20px;
}

.content-list {
	display: grid;
	grid-template-columns: repeat(3, 1fr);
	grid-gap: 20px;
}

footer {
	background-color: #333;
	color: #fff;
	text-align: center;
	padding: 10px 0;
	margin-top: 20px;
}

/* Responsive design for smaller screens */
@media ( max-width : 768px) {
	nav {
		flex-direction: column;
		align-items: flex-start;
	}
	.logo h1 {
		font-size: 24px;
	}
	.nav-links {
		margin-top: 10px;
	}
	.nav-links li {
		margin-left: 0;
		margin-bottom: 10px;
	}
	.main {
		padding: 10px;
	}
	h2 {
		font-size: 22px;
		margin-bottom: 15px;
	}
	.content-list {
		grid-template-columns: repeat(1, 1fr);
	}
	footer {
		font-size: 14px;
	}
}
</style>
</head>
<body>
	<header>
		<nav>
			<div class="container1">
				<div class="logo">
					<h1>CMS</h1>
				</div>
				<ul class="nav-links">
					<li><a href="signin.jsp">Sign In</a></li>
					<li><a href="signup.jsp">Sign Up</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<main>
		<div class="container2">
			<h2>Welcome to the Content Management System</h2>
			<div class="content-list">
				<!-- Content will be dynamically loaded here -->
			</div>
		</div>
	</main>

	<footer>
		<div class="container2">
			<p>&copy; 2023 Your CMS. All rights reserved.</p>
		</div>
	</footer>

	<!-- JavaScript to fetch and display content -->
	<script src="script.js"></script>
</body>
</html>
