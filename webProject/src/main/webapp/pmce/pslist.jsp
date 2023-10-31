<%@page import="project_DTO.PerformanceVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>���������ϼ�</title>
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
	<h1>���� ������ ��</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>�̸�</th>
			<th>������</th>
			<th>������</th>
			<th>����</th>
			<th>����</th>
		</tr>
		<%
		// Java ������ ���� (������ ������)
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