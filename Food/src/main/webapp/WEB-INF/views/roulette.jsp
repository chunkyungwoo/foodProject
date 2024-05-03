<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<title>Roulette</title>
<link rel="stylesheet" type="text/css" href="${rootPath}/static/css/roulette.css?2024-04-18-002">
</head>
<body>
    <!-- canvas 요소 추가 -->
    <canvas id="roulette" width="500" height="500"></canvas>
    <button id="spin">Spin</button>

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="${rootPath}/static/js/roulette.js?2024-04-18-002"></script>
</body>
</html>