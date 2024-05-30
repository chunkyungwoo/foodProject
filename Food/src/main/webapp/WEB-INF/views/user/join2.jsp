<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${rootPath}/static/css/join.css?2024-04-18-007" >
<script>
	const rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/user.js?2024-04-18-007"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<h1>회원가입</h1>
	<f:form class="join" method="POST">
		<div><input placeholder="ID" name="m_id"></div>
		<div><input placeholder="PASSWORD" name="m_password"></div>
		<div><input placeholder="RE PASSWORD" name="re_password"></div>
		<div><input placeholder="EMAIL" name="m_email"></div>
		<div><input placeholder="NAME" name="m_name"></div>
		<div><input placeholder="TEL" name="m_tel"></div>
		<div class="foodcontainer">
			<select name="f_foodname" id="food" multiple size="2"></select>
			<input type="hidden" name="selected_food">
		</div>
		<div><button type="button">회원가입</button></div>
		<a href="${rootPath}/user/login">로그인</a>
	</f:form>
<!-- 	<script>
        document.addEventListener("DOMContentLoaded", () => { 
            populateFoodDropdown();
            
            const join_form = document.querySelector("form.join");
            const f_foodname = join_form.querySelector("select[name='f_foodname']");
            const btn_join = join_form.querySelector("button");

            btn_join.addEventListener("click", () => {
                const selectedFoods = [];
                for (let i = 0; i < f_foodname.options.length; i++) {
                    if (f_foodname.options[i].selected) {
                        selectedFoods.push(f_foodname.options[i].text);
                    }
                }
                if (selectedFoods.length === 0) {
                    alert("음식취향을 선택하세요.");
                    return false;
                }
                const foodInput = document.querySelector("input[name='selected_food']");
                foodInput.value = selectedFoods.join(", ");
                join_form.submit();
            });

            async function populateFoodDropdown() {
                try {
                    const res = await fetch("/food/list");
                    const data = await res.json();
                    data.forEach((food) => {			
                        $("#food").append("<option value="+food.f_code+">"+food.f_foodname+"</option>");
                    });
                } catch (error) {
                    console.error("음식정보 오류", error);
                }
            }
        });
    </script>  -->
	
</body>
</html>