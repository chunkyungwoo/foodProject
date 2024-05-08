<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<link rel="stylesheet" href="${rootPath}/static/css/main.css?2024-04-18-001">
<script src="${rootPath}/static/js/main_nav.js?2024-04-19"></script>
<%@ include file="/WEB-INF/views/include/head.jspf"%>
<body>
	<nav class="main">
		<ul>
			<li><a href="${rootPath}/food/random">랜덤돌리기</a></li>
			<li><a href="${rootPath}/user/login">로그인</a></li>
			<li><a href="${rootPath}/user/join">회원가입</a>
			<sec:authorize access="isAuthenticated()">
				<li>
					<a href="${rootPath}/user/mypage">마이페이지</a>
					<sec:authentication property="principal['m_id']" />
				</li>
					<li><f:form action="${rootPath}/user/logout" onclick="this.submit()">로그아웃</f:form></li>
			</sec:authorize>
		</ul>
	</nav>
</body>
</html>
