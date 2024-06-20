<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <style type="text/css">
body {
    margin: 0px;
    padding: 0px;
    background-color: #343434;
}

h3 {
    margin-bottom: 5px;
    margin-left: 15px;
    color: white;
}

li {
    color: white;
    margin-left: 10px;
    text-decoration: none;
}

li > a {
    color: white;
    text-decoration: none;
}

li > a:hover {
    text-decoration: underline;
}

ul {
    padding-left: 20px;
    margin: 0px;
}

li {
    padding: 2px;
}

.nav_none_list {
    list-style-type: none;
    padding: 0px;
    margin: 0px;
}

.nav_background {
    background-color: #1E1E1E;
    width: 200px;
    padding: 10px;
    margin: 15px;
    margin-top: 5px;
}

#search {
    width: 130pt;
    height: 20pt;
    font-size: large;
}

#title {
    margin-left: 35pt;
    color: #E50914;
    text-shadow: 3px 3px rgba(0, 0, 0, 0.25);
    font-weight: 900;
    font-size: 45pt;
}

h1 {
    display: inline-block;
}

form {
    display: inline-block;
    float: right;
    margin-right: 20pt;
}

form a {
    display: inline-block;
    float: right;
}

#login_signin {
    color: white;
    margin-top: 50pt;
}

a {
    color: white;
    text-decoration: none;
}

#top {
    color: white;
    margin-left: 10pt;
}

table, table td {
    border-style: solid;
    border-color: #1E1E1E;
    border-width: 20pt;
    border-collapse: collapse;
    text-align: center;
    color: white;
}

#movietalk > tbody > tr > td {
    border-width: 2pt;
    border-color: #1E1E1E;
    background-color: #E50914;
}

main {
    display: flex;
}

nav {
    flex: 0 0 220px; /* 좌측에 고정된 넓이 */
    margin: 15px;
}

#moviepostertalk {
    flex: 1; /* 남은 공간을 차지 */
    margin: 15px;
}

.poster-container {
    position: relative;
    width: 100%;
    padding-top: 150%; /* 3:2 비율 유지 */
    overflow: hidden;
    background-color: #333;
    border: 2px solid #1E1E1E;
    margin: 10px;
}

.poster-container img {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    object-fit: cover;
}

</style>
</head>
<body>
  <header>
  <h1 id="title">WEBFLIX</h1>
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

  </header>
  <main>
    <nav>
      <h3>게시판 목록</h3>
      <div class="nav_background">
        <ul class="nav_none_list">
          <li>
            <a href="/">메인 페이지</a>
          </li>
          <li>
            <a href="/webflix/popular">인기 드라마</a>
          </li>
        </ul>
      </div>
      
        
          
    </nav>
    <div id="moviepostertalk">
      <section id="poster">
        <h3 id="top">TOP10</h3>
    <c:if test="${not empty error}">
        <p style="color: red;">${error}</p>
    </c:if>
    <c:if test="${not empty movies}">
        <table id="movieposter">
            <c:forEach var="movie" items="${movies}" varStatus="status">
                <c:if test="${status.index % 5 == 0}">
                    <tr>
                </c:if>
                <td>
                    <img src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="${movie.title}"/>
                    <p>${movie.title}</p>
                </td>
            </c:forEach>
        </table>
    </c:if>
      </section>
    </div>
  </main>
</body>
</html>