<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>SHOW��</title>
	<style>
		body {
    		margin: 120; /*0*/
    		background-image: url(static/image/texture.jpg), url(static/image/texture.jpg); /* �̹��� ������ ��θ� �����ؾ� �մϴ�. */
   			background-size: auto 95%, auto 95%; /* �̹����� ȭ�� ũ�⿡ �°� �ø��ϴ�. */ /*166*/
    		background-position: left, right; 
    		background-repeat: repeat-y, repeat-y; /* �̹��� �ݺ� ���� */
		}
		#logindiv {
			width: 800px;
			text-align: right;
			margin: auto;
		}
		 #logout {
            background-color: rgb(213, 232, 218);
            outline: 2px solid #898989; /* �ƿ����� �� �� �β� ���� */
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
			/*ul�� ���̸� �Ⱥ��̰� ó��*/
			overflow: hidden;
		}

		.menu>li:hover {
			background-color: rgb(38, 164, 138);
			transition-duration: 0.5s;
		}

		.menu>li:hover .submenu {
			height: 200px;
			/*����޴� li�Ѱ��� ���� 50*5*/
			transition-duration: 1s;
			}
	</style>
</head>

<body>
	<h1>SHOW��</h1>
	<div id="logindiv">
	<button id="logout">�α׾ƿ�</button>
	</div>
	<body>
		<ul class="menu">
			<li>
				<a href="#">INFO</a>
				<ul class="submenu">
					<li><a href="#">����</a></li>
					<li><a href="#">�Ұ�</a></li>
					<li><a href="#">�λ縻</a></li>
					<li><a href="#">Service</a></li>
				</ul>
			</li>
			<li>
				<a href="#">SHOW</a>
				<ul class="submenu">
					<li><a id=plist href="#">���� ��ȸ</a></li>
					<li><a href="#">���� �˻�</a></li>
					<li><a id=pslist href="#">���������ϼ�</a></li>
					<li><a href="#">���ɰ������</a></li>
				</ul>
			</li>
			<li>
				<a href="#">MYPAGE</a>
				<ul class="submenu">
					<li><a href="#">������ȸ</a></li>
					<li><a href="#">��������</a></li>
					<li><a href="#">���ɸ����ȸ</a></li>
					<li><a href="#">Ż��</a></li>
				</ul>
			</li>
			<li>
				<a href="#">������</a>
				<ul class="submenu">
					<li><a href="#">QnA</a></li>
					<li><a href="#">���ǻ���</a></li>
					<li><a href="#">���� ���� ����</a></li>
					<li><a id=receipt href="#">�Ҹ� ����</a></li>
				</ul>
			</li>
		</ul>
	</body>
	<script>
		document.querySelector("#logout").addEventListener("click", function (event) {
			event.preventDefault(); // �⺻ ��ũ ������ �����ϴ�.
			location.href = "views/logout.do"; // ���ϴ� URL�� �̵��մϴ�.
		});
		document.querySelector("#plist").addEventListener("click", function (event) {
			event.preventDefault(); // �⺻ ��ũ ������ �����ϴ�.
			location.href = "./pmce/plist.do"; // ���ϴ� URL�� �̵��մϴ�.
		});
		document.querySelector("#pslist").addEventListener("click", function (event) {
			event.preventDefault(); // �⺻ ��ũ ������ �����ϴ�.
			location.href = "./pmce/pslist.do"; // ���ϴ� URL�� �̵��մϴ�.
		});
		document.querySelector("#receipt").addEventListener("click", function (event) {
			event.preventDefault(); // �⺻ ��ũ ������ �����ϴ�.
			location.href = "views/receipt.jsp"; // ���ϴ� URL�� �̵��մϴ�.
		});
	</script>
</body>

</html>