<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}/static/css/login.css?2024-04-18-001" >
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/login.js?2024-04-18-007"></script>
</head>
<body>
	<h1>로그인</h1>
	<f:form class="login">
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != null}">
			<div>${SPRING_SECURITY_LAST_EXCEPTION.message}</div>
		</c:if>
		<div><input type="text" placeholder="ID" name="m_id"/></div>
		<div><input type="password" placeholder="PASSWORD" name="m_password"/></div>
		<div><button>로그인</button></div>
		<a href="${rootPath}/user/join">회원가입</a>
		<a href="${rootPath}/user/find">아이디 비밀번호찾기</a>
	</f:form>
</body>
</html>