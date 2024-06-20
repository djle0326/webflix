<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link href="/static/css/styles.css" rel="stylesheet" type="text/css">


</head>
<body>
  <header>
  <h1 id="title">WEBFLIX</h1>
	<%@ include file="/WEB-INF/views/module/login.jsp" %>


  </header>
  <main>
  <%@ include file="/WEB-INF/views/module/nav.jsp" %>
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