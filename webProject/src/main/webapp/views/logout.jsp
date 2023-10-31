<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그아웃</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #3498db;
            text-align: center;
            margin: auto;
            padding: 232px;
            color: #fff;
        }

        .container {
            padding: 20px;
            background-color: #2980b9;
            border-radius: 5px;
            width: 300px;
            margin: 0 auto;
            margin-top: 100px;
        }

        h1 {
            font-size: 24px;body {
    		font-family: 'Arial', sans-serif;
    		background-color: #3498db;
    		text-align: center;
    		margin: 0;
    		padding: 0;
    		color: #fff;
    		display: flex;
    		justify-content: center;
    		align-items: center;
    		height: 100vh;
		}

		.container {
    		padding: 20px;
    		background-color: #2980b9;
    		border-radius: 5px;
    		width: 300px;
		}

		h1 {
    		font-size: 24px;
		}

		p {
    		font-size: 16px;
    		margin: 20px 0;
		}

		#message {
    		font-size: 20px;
    		font-weight: bold;
    		color: #2ecc71;
		}
    </style>
    
</head>
<body>
    <h1>로그아웃 성공</h1>
    <p>안전하게 로그아웃되었습니다.</p>
    <p>홈페이지로 이동합니다. 잠시만 기다려 주세요</p>
    <p id="message"></p>

    <script>
        var message = "<%= session.getAttribute("logoutMessage") %>";
        if (message !== "") {
            document.getElementById("message").textContent = message;

            setTimeout(function() {
               window.location.href = "../index.html"; // 자동 리디렉션할 페이지 URL
           }, 3000); // 3초 후 리디렉션 (원하는 시간(밀리초)으로 수정)
        }
    </script>
    
</body>
</html>
