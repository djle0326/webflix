<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<form>
		<div id="login_signin">
		<c:if test="${sessionScope.isLoggedIn}">
		    <!-- 로그인 -->
		    <a href="/webflix/logout">로그아웃</a>
		    <a>&nbsp; | &nbsp;</a>
		    <a href="myPage.jsp">정보수정</a>
		</c:if>
		<c:if test="${not sessionScope.isLoggedIn}">
		    <!-- 비로그인 -->
		    <a href="/webflix/login-form">로그인</a>
		    <a>&nbsp; | &nbsp;</a>
		    <a href="/webflix/register">회원가입</a>
		</c:if>
			<br>
		</div>
    </form>