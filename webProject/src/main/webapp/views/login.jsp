<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
  <script>
     var message = "${loginResult}";
     if(message!=""){
    	 alert(message);
     }
  </script>
</head>
<body>

<div class="container mt-3" style="max-width: 400px;">
  <h2>LOGIN</h2>
  <form action="loginCheck.do" method="post">
    <div class="mb-3 mt-3">
      <label for="userid" style="font-size: 18px;">아이디:</label>
      <input type="text" class="form-control" id="userid" placeholder="Enter userid" name="userid" style="width: 80%;">
    </div>
    <div class="mb-3">
      <label for="pswd" style="font-size: 18px;">비밀번호:</label>
      <input type="password" class="form-control" id="pswd" placeholder="Enter password" name="pswd" style="width: 80%;">
    </div>
    <div class="form-check mb-3">
      <label class="form-check-label" style="font-size: 16px;">
        <input class="form-check-input" type="checkbox" name="remember"> Remember me
      </label>
    </div>
    <button type="submit" class="btn btn-outline-primary">로그인</button>
    <button type="button" class="btn btn-outline-dark" onclick="redirectToSignUp()">회원가입</button>
  </form>
</div>

	<script>
  		function redirectToSignUp() {
    	window.location.href = "userinsert.do"; // 회원가입 페이지로 이동
  		}
	</script>

</body>
</html>
