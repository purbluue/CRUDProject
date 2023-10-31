<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>회원가입</title>
<style>
  body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
  }
  h1 {
    text-align: center;
    color: #333;
  }
  form {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    background-color: #fff;
    border-radius: 5px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
  }
  label {
    display: block;
    margin-top: 10px;
    font-weight: bold;
  }
  input[type="text"],
  input[type="password"],
  input[type="number"],
  input[type="email"] {
    width: 95%;
    padding: 10px;
    margin: 5px 0;
    border: 1px solid #ccc;
    border-radius: 3px;
  }
  input[type="submit"] {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 3px;
    padding: 10px 20px;
    cursor: pointer;
  }
  input[type="submit"]:hover {
    background-color: #0056b3;
  }
  .my-button {
    background-color: #007bff;
    color: #fff;
    border: none;
    border-radius: 3px;
    padding: 10px 20px;
    cursor: pointer;
  }
	.my-button:hover {
    background-color: #0056b3;
  }

</style>
</head>
<body>
	<h1>회원가입</h1>
	<form action="userinsert.do" method="post" accept-charset="UTF-8">
		<label for="userid">아이디:</label> <input type="text" id="userid"
			name="userid" required><br>
		<br> <label for="username">사용자 이름:</label> <input type="text" id="username"
			name="username" required><br>
		<br> <label for="password">비밀번호:</label> <input type="password"
			id="password" name="password" required><br>
		<br> <label for="phone">전화번호:</label> <input type="number"
			id="phone" name="phone" required><br>
		<br> <label for="email">이메일:</label> <input type="email"
			id="email" name="email" required><br>

		<br> <input type="submit" value="가입하기">
			<!-- "돌아가기" 버튼을 클릭하면 이전 페이지로 이동 -->
		<button class="my-button" onclick="goBack()">돌아가기</button>
	</form>
	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>