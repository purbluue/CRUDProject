<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 결과</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 100vh;
	text-align: center;
}

h1 {
	color: #3498db;
	font-size: 2em;
	margin: 20px;
}

#message {
	font-size: 1.2em;
	background-color: #fff;
	padding: 20px;
	margin: 20px;
	border-radius: 5px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
	max-width: 400px;
}
</style>

</head>
<body>
	<h1>회원가입 결과</h1>
	<p id="message"></p>

	<script>
        var message = "<%=session.getAttribute("joinResult")%>";
		if (message !== "") {
			document.getElementById("message").textContent = message;

			setTimeout(function() {
				window.location.href = "login.jsp"; // 리디렉션할 페이지 URL
			}, 2000); // 2초 후 리디렉션 (원하는 시간(밀리초)으로 수정)
		}
	</script>
</body>
</html>