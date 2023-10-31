<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>직원정보(DB에 저장할 예정)</h1>
<p><%=request.getParameter("EMPLOYEE_ID") %></p>
<p><%=request.getParameter("FIRST_NAME") %></p>
<p><%=request.getParameter("LAST_NAME") %></p>
<p><%=request.getParameter("EMAIL") %></p>
<p><%=request.getParameter("PHONE_NUMBER") %></p>
<p><%=request.getParameter("HIRE_DATE") %></p>
<p><%=request.getParameter("JOB_ID") %></p>
<p><%=request.getParameter("SALARY") %></p>
<p><%=request.getParameter("COMMISSION_PCT") %></p>
<p><%=request.getParameter("MANAGER_ID") %></p>
<p><%=request.getParameter("DEPARTMENT_ID") %></p>

</body>
</html>