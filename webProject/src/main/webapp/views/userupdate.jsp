<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>사용자 정보 수정</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f3f3f3;
            margin: 0;
            padding: 0;
            text-align: center;
        }
        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        h2 {
            color: #007BFF;
        }
        input[type="text"], input[type="password"] {
            width: 90%;
            padding: 10px;
            margin: 10px 0;
            border: 1px solid #ccc;
            border-radius: 5px;
        }
        input[type="submit"] {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-weight: bold;
        }
        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <form action="userupdate.do" method="post" accept-charset="UTF-8">
        <!--<input type="text" name="user_id" placeholder="사용자 ID">  -->
        <input type="text" name="reuser_id" placeholder="새로운 사용자 ID">
        <input type="text" name="reuser_name" placeholder="새로운 사용자 이름">
        <input type="password" name="reuser_password" placeholder="새로운 비밀번호">
        <input type="text" name="reuser_phone" placeholder="새로운 전화번호">
        <input type="text" name="reuser_email" placeholder="새로운 이메일">
        <input type="submit" value="업데이트">
    </form>
</body>
</html>