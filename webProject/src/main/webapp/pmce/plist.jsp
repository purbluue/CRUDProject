<%@page import="java.util.ArrayList"%>
<%@page import="project_DTO.PerformanceVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연 정보 조회</title>
<style>
body {
	font-family: Arial, sans-serif;
}

h1 {
	background-color: #333;
	color: #fff;
	padding: 10px;
	text-align: center;
}

table {
	width: 80%;
	margin: 20px auto;
	border-collapse: collapse;
}

th, td {
	padding: 10px;
	text-align: center;
}

th {
	background-color: #333;
	color: #fff;
}

tr:nth-child(even) {
	background-color: #f2f2f2;
}

tr:nth-child(odd) {
	background-color: #fff;
}
</style>

</head>
<body>
	<h1>공연 정보 조회</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>이름</th>
			<th>시작일</th>
			<th>종료일</th>
			<th>감독</th>
			<th>가격</th>
		</tr>
		<%
		// Java 데이터 생성 (가상의 데이터)
		List<PerformanceVO> plist = (List<PerformanceVO>)request.getAttribute("plist");

		for (PerformanceVO performance : plist) {
		%>
		<tr>
			<td><%=performance.getP_id()%></td>
			<td><%=performance.getP_name()%></td>
			<td><%=performance.getP_sdate()%></td>
			<td><%=performance.getP_edate()%></td>
			<td><%=performance.getP_director()%></td>
			<td><%=performance.getP_price()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>