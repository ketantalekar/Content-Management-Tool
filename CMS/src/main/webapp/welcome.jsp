<%@page import="com.dao.ContentDao"%>
<%@page import="com.model.Content"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.util.List"%>
<%@page import="com.util.ImageUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Page</title>
<style type="text/css">
/* Reset some default styles */
body, h3, h4, form, table {
	margin: 0;
	padding: 0;
	border: 0;
}

body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
}

h3, h4 {
	background-color: #333;
	color: #fff;
	padding: 20px;
	text-align: center;
}

form {
	background-color: #fff;
	padding: 20px;
	margin: 20px auto;
	width: 80%;
	box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

table {
	width: 100%;
}

td {
	padding: 10px;
}

input[type="text"], input[type="file"], textarea {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 4px;
	margin-bottom: 10px;
}

input[type="submit"] {
	background-color: #333;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 4px;
}

button {
	background-color: #333;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
	border-radius: 4px;
	align-items: center;
}
input[type="submit"]:hover {
	background-color: #555;
}

/* Style for required fields */
input:required, textarea:required {
	border-color: #f00;
}

/* Style for file input */
input[type="file"] {
	border: none;
	padding: 0;
	background: transparent;
	cursor: pointer;
}

/* Style for file input label */
input[type="file"]+label {
	background-color: #333;
	color: #fff;
	padding: 10px 20px;
	border-radius: 4px;
	cursor: pointer;
	display: inline-block;
	margin-bottom: 10px;
}

/* Style for file input label on hover */
input[type="file"]+label:hover {
	background-color: #555;
}
</style>
</head>
<body>
	<h3>Welcome to Our Content Management System</h3>
	<form action="ContentServlet" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Content Title:</td>
				<td><input type="text" name="title" required></td>
			</tr>
			<tr>
				<td>Content Image:</td>
				<td><input type="file" name="image" accept="image/*" required></td>
			</tr>
			<tr>
				<td>Content Description:</td>
				<td><textarea name="description" rows="4" cols="50" required></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="b1"
					value="Add Content"></td>
			</tr>
		</table>
	</form>
	<hr>
	<h4>Content List</h4>

	<table>
		<tr>
			<th>Title</th>
			<th>Image</th>
			<th>Description</th>
		</tr>
		<%
		// Assuming you have a List of Content objects named contentList
		List<Content> contentList = (List<Content>) request.getAttribute("contentList");
		if (contentList != null && !contentList.isEmpty()) {
			for (Content content : contentList) {
				Blob imageBlob = content.getImage();
				String encodedImage = ImageUtil.encodeImageToBase64(imageBlob);
				Content c = new Content();
				
		%>
		<tr>
			<td><%=content.getCtitle()%></td>
			<td><img src="data:image/jpeg;base64,<%=encodedImage%>"
				alt="Content Image" width="100"></td>
			<td><%=content.getCdescription()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="3">No content available.</td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
