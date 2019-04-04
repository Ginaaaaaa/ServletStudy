<%@page import="com.vigteam.study.vo.LogVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Logs</h1>
	
	<ul>
<%
List<LogVo> list = (List<LogVo>)request.getAttribute("list"); 
for (LogVo vo: list) {
%>
<li><%= vo %></li>
<%
}
%>

	</ul>
	<!-- HTML Form -->
	<form action="<%= request.getContextPath()/*ServletStudy*/ %>/logs"
		method="POST">
		<label for="name">이름</label>
		<input type="text" name="name"><br>
		<label for="log">기록</label>
		<input type="text" name="log"><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>