<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center; vertical-align: middle; align-self: center;">
<h1>Image Uploading</h1>
		<form action="image_uploading" method="post" enctype="multipart/form-data">
			ID<input type="text" name="id" placeholder="Enter your id">
			<br> 
			NAME<input type="text" name="name"	placeholder="Enter your name"> <br>
			IMAGE <input
				type="file" name="image" required="required" /><br /> 
				<br /> <input type="submit" />
		</form>
	</div>
</body>
</html>