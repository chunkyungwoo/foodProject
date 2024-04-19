<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>돌려~</h1>
	<ul>
		<li th:each="item : ${data}" th:text="${item}"></li>
	</ul>

</body>
</html>