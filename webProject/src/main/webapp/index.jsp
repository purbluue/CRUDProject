<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>SHOW봄</title>
	<style>
		body {
    		margin: 120; /*0*/
    		background-image: url(static/image/texture.jpg), url(static/image/texture.jpg); /* 이미지 파일의 경로를 지정해야 합니다. */
   			background-size: auto 95%, auto 95%; /* 이미지를 화면 크기에 맞게 늘립니다. */ /*166*/
    		background-position: left, right; 
    		background-repeat: repeat-y, repeat-y; /* 이미지 반복 없음 */
		}
		#logindiv {
			width: 800px;
			text-align: right;
			margin: auto;
		}
		 #logout {
            background-color: rgb(213, 232, 218);
            outline: 2px solid #898989; /* 아웃라인 색 및 두께 설정 */
            border: none;
            color: rgb(0, 64, 0);
            padding: 3px 10px;
            margin: 5px;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
        }

        #logout:hover {
            background-color: rgb(0, 64, 128);
        }
		h1 {
			margin: 30px auto;
			color: rgb(87, 215, 189);
			text-align: center;
			font-size: 3rem;
		}

		* {
			padding: 0;
			margin: 0
		}

		li {
			list-style: none;
		}

		a {
			text-decoration: none;
			font-size: 14px
		}

		.menu {
			display: table;
			table-layout: fixed;
			width: 800px;
			margin: 20px auto;
			text-align: center;
		}

		.menu>li {
			display: table-cell;
			text-align: center;
			line-height: 40px;
			background-color: rgb(28, 115, 98);
		}

		.menu a {
			color: #fff;
		}

		.submenu>li {
			line-height: 50px;
			background-color: rgb(87, 215, 189);
		}

		.submenu {
			height: 0;
			/*ul의 높이를 안보이게 처리*/
			overflow: hidden;
		}

		.menu>li:hover {
			background-color: rgb(38, 164, 138);
			transition-duration: 0.5s;
		}

		.menu>li:hover .submenu {
			height: 200px;
			/*서브메뉴 li한개의 높이 50*5*/
			transition-duration: 1s;
			}
	</style>
</head>

<body>
	<h1>SHOW봄</h1>
	<div id="logindiv">
	<button id="logout">로그아웃</button>
	</div>
	<body>
		<ul class="menu">
			<li>
				<a href="#">INFO</a>
				<ul class="submenu">
					<li><a href="#">정보</a></li>
					<li><a href="#">소개</a></li>
					<li><a href="#">인사말</a></li>
					<li><a href="#">Service</a></li>
				</ul>
			</li>
			<li>
				<a href="#">SHOW</a>
				<ul class="submenu">
					<li><a id=plist href="#">공연 조회</a></li>
					<li><a href="#">공연 검색</a></li>
					<li><a id=pslist href="#">공연시작일순</a></li>
					<li><a href="#">관심공연등록</a></li>
				</ul>
			</li>
			<li>
				<a href="#">MYPAGE</a>
				<ul class="submenu">
					<li><a href="#">정보조회</a></li>
					<li><a href="#">정보수정</a></li>
					<li><a href="#">관심목록조회</a></li>
					<li><a href="#">탈퇴</a></li>
				</ul>
			</li>
			<li>
				<a href="#">고객센터</a>
				<ul class="submenu">
					<li><a href="#">QnA</a></li>
					<li><a href="#">문의사항</a></li>
					<li><a href="#">자주 묻는 질문</a></li>
					<li><a id=receipt href="#">불만 접수</a></li>
				</ul>
			</li>
		</ul>
	</body>
	<script>
		document.querySelector("#logout").addEventListener("click", function (event) {
			event.preventDefault(); // 기본 링크 동작을 막습니다.
			location.href = "views/logout.do"; // 원하는 URL로 이동합니다.
		});
		document.querySelector("#plist").addEventListener("click", function (event) {
			event.preventDefault(); // 기본 링크 동작을 막습니다.
			location.href = "./pmce/plist.do"; // 원하는 URL로 이동합니다.
		});
		document.querySelector("#pslist").addEventListener("click", function (event) {
			event.preventDefault(); // 기본 링크 동작을 막습니다.
			location.href = "./pmce/pslist.do"; // 원하는 URL로 이동합니다.
		});
		document.querySelector("#receipt").addEventListener("click", function (event) {
			event.preventDefault(); // 기본 링크 동작을 막습니다.
			location.href = "views/receipt.jsp"; // 원하는 URL로 이동합니다.
		});
	</script>
</body>

</html>