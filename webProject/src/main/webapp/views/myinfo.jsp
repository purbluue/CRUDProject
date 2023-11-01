<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>내 정보</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	text-align: center;
}

h1 {
	color: #333;
}

.user-info {
	background-color: #fff;
	border: 1px solid #ddd;
	border-radius: 5px;
	padding: 20px;
	margin: 20px auto;
	width: 50%;
}

p {
	margin: 10px 0;
}

.not-found {
	font-weight: bold;
	color: red;
}
</style>
</head>
<body>
	<h1>내 정보</h1>
	<c:if test="${empty user}">
		<p>사용자 정보를 찾을 수 없습니다.</p>
	</c:if>
	<c:if test="${not empty user}">
		<p>사용자 번호: ${user.user_no}</p>
		<p>사용자 아이디: ${user.user_id}</p>
		<p>사용자 이름: ${user.user_name}</p>
		<p>사용자 전화번호: ${user.user_phone}</p>
		<p>사용자 이메일: ${user.user_email}</p>
	</c:if>
</body>
</html>