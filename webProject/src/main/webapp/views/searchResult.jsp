<%@page import="javax.naming.directory.SearchResult"%>
<%@page import="project_DTO.PerformanceVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Search Result</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f5f5f5;
	margin: 0;
	padding: 0;
}

h1 {
	background-color: #333;
	color: #fff;
	padding: 20px;
	text-align: center;
}

.search-results {
	max-width: 800px;
	margin: 0 auto;
	background-color: #fff;
	border-radius: 5px;
	box-shadow: 0 0 5px rgba(0, 0, 0, 0.3);
	padding: 20px;
	margin-top: 20px;
}

ul {
	list-style: none;
	padding: 0;
}

li {
	margin: 10px 0;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 5px;
	background-color: #f9f9f9;
}
</style>
</head>
<body>
	<h1>Search Result</h1>
	<div class="search-results">
		<h2>검색 결과:</h2>
	 
		<ul>
			<c:forEach items="${pname}" var="result">
				<li>${result.p_name} - ${result.p_director}</li>
			</c:forEach>
		</ul>
	</div>
	
	<%-- <c:if test="${not empty searchResult}">
    <ul>
        <c:forEach items="${searchResult}" var="result">
            <li>${result.p_name} - ${result.p_director}</li>
        </c:forEach>
    </ul>
</c:if> --%>
<<%--  c:if test="${empty searchResult}">
    <p>검색 결과가 없습니다.</p>
</c:if>--%>
</body>
</html>