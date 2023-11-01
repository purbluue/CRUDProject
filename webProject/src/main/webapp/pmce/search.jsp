<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Search Page</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

h1 {
	background-color: #333;
	color: #fff;
	padding: 20px;
	text-align: center;
}

form {
	max-width: 400px;
	margin: 0 auto;
	padding: 20px;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
}

label {
	display: block;
	margin-top: 10px;
}

select, input[type="text"], input[type="submit"] {
	width: 100%;
	padding: 10px;
	margin-top: 5px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

input[type="submit"] {
	background-color: #333;
	color: #fff;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #555;
}
</style>
</head>
<body>
	<h1>Search for Performances</h1>
	<form action="../views/search.do" method="get">
		<select name="searchType">
			<option value="performance" selected="selected">공연명</option>
			<option value="director">연출가</option>
		</select> <input type="text" name="searchQuery" placeholder="검색어를 입력하세요">
		<input type="submit" value="검색">
	</form>
</body>
</html>