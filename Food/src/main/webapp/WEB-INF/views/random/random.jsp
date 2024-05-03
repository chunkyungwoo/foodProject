<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${rootPath}/static/css/random.css?2024-04-18-001">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="${rootPath}/static/js/random.js?2024-04-26-002"></script>
<title>Random Food Selector</title>
</head>
<body>
	<div class="container">
		<h1>랜덤돌림판</h1>
		<div class="roulette-container">
			<div class="roulette">
				<div class="arrow"></div>
				<ul class="food-list">
					<li>일식</li>
					<li>양식</li>
					<li>중식</li>
					<li>한식</li>
					<li>아시안</li>
					<li>분식</li>
					<li>패스트푸드</li>
				</ul>
			</div>
		<button id="randomButton">돌려</button>
		</div>
	</div>
	<div class="selectfood">
		<div>
			<input readonly="readonly">
			<input>
		</div>
		<button id="selectButton">돌려</button>
	</div>
	
</body>
</html>