<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>WEBFLIX</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <style>
    /* Additional styling for images and layout */
    table img {
        width: 100%; /* Image fills the width of its parent */
        height: auto; /* Maintain aspect ratio */
        object-fit: cover; /* Maintain aspect ratio and cover the area */
    }
    table td, table th {
        padding: 10px; /* Adjust padding as necessary */
        text-align: center; /* Center content */
        vertical-align: middle; /* Center content vertically */
    }
    body {
        background-color: #343434;
    }
    h1, h3, p, a {
        color: white;
    }
  </style>
</head>
<body>
  <header class="bg-dark text-white p-3">
    <div class="container">
      <h1 id="title" class="mb-0">WEBFLIX</h1>
      <div id="login_signin" class="float-right">
        <a href="/webflix/login-form" class="text-white">로그인</a>
        <span>&nbsp; | &nbsp;</span>
        <a href="/webflix/register" class="text-white">회원가입</a>
      </div>
    </div>
  </header>
  <main class="container mt-4">
    <div class="row">
      <aside class="col-md-3">
        <h3>게시판 목록</h3>
        <div class="nav_background p-3 bg-secondary">
          <ul class="nav_none_list list-unstyled">
            <li>
              <a href="/webflix" class="text-white">메인 페이지</a>
            </li>
            <li>
              <p><a href="/webflix/popular/drama" class="text-white">넷플릭스 인기 드라마</a></p>
              <p><a href="/webflix/popular/movie" class="text-white">넷플릭스 인기 영화</a></p>
            </li>
          </ul>
        </div>
      </aside>
      <main id="moviepostertalk" class="col-md-9">
        <section id="poster">
          <h3 id="top" class="text-white">NETFLIX TOP10 영화</h3>
          <c:if test="${not empty error}">
              <p style="color: red;">${error}</p>
          </c:if>
          <c:if test="${not empty movies}">
              <table id="movieposter" class="table table-dark table-bordered">
                  <tbody>
                      <c:forEach var="movie" items="${movies}" varStatus="status">
                          <c:if test="${status.index % 5 == 0}">
                              <tr>
                          </c:if>
                          <td>
                              <img src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="${movie.title}" class="img-fluid"/>
                              <p>${movie.title}</p>
                          </td>
                          <c:if test="${(status.index + 1) % 5 == 0}">
                              </tr>
                          </c:if>
                      </c:forEach>
                  </tbody>
              </table>
          </c:if>
        </section>
      </main>
    </div>
  </main>
  <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
