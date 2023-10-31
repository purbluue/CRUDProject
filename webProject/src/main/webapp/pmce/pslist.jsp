<%@page import="project_DTO.PerformanceVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공연시작일순</title>
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
	<h1>공연 시작일 순</h1>
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
		List<PerformanceVO> pslist = (List<PerformanceVO>)request.getAttribute("pslist");

		for (PerformanceVO performanceList : pslist) {
		%>
		<tr>
			<td><%=performanceList.getP_id()%></td>
			<td><%=performanceList.getP_name()%></td>
			<td><%=performanceList.getP_sdate()%></td>
			<td><%=performanceList.getP_edate()%></td>
			<td><%=performanceList.getP_director()%></td>
			<td><%=performanceList.getP_price()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>