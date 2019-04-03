<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//	Java Code (logic이 들어가야 할 때, 스크립틀릿)
// WelcomeServlet으로부터 넘겨받은 name 속성을 받아온다.
String name = (String)request.getAttribute("name"); //(string)은 강제 캐스팅, 어떤 종류의 값을 받아오는지 모르니까
%>

<h1>Welcome, <%= name %></h1>

</body>
</html>