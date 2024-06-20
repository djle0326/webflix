<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>WEBFLIX</title>
  <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" type="text/css">
  <style>
    /* Fixed size for images and ensure they fit within the cell */
    table img {
        width: 100px; /* Fixed width */
        height: 150px; /* Fixed height */
        object-fit: cover; /* Maintain aspect ratio and cover the area */
    }
    table td, table th {
        padding: 10px; /* Adjust padding as necessary */
        text-align: center; /* Center content */
        vertical-align: middle; /* Center content vertically */
        overflow: hidden; /* Prevent overflow */
    }
    /* Truncate long text with ellipsis */
    .truncate {
        white-space: nowrap;
        overflow: hidden;
        text-overflow: ellipsis;
        max-width: 150px; /* Adjust as necessary */
    }
    body {
        background-color: #343434;
    }
    h1, h3, p, a {
        color: white;
    }
  </style>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script>
    $(document).ready(function() {
      $('#sort_by').change(function() {
        var sortBy = $(this).val();
        console.log('Selected sort by:', sortBy); // Debugging: Log the selected sort option
        $.ajax({
          url: '/webflix/popular/movie',
          type: 'GET',
          data: { sort_by: sortBy },
          success: function(data) {
            console.log('AJAX call successful'); // Debugging: Log success
            console.log('Received data:', data); // Debugging: Log received data
            $('#movieTable tbody').html($(data).find('#movieTable tbody').html());
          },
          error: function(xhr, status, error) {
            console.log('AJAX call failed:', status, error); // Debugging: Log errors
            alert('Failed to fetch data. Please try again.');
          }
        });
      });
    });
  </script>
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
      <div id="moviepostertalk" class="col-md-9">
        <section id="poster">
          <h3 id="top" class="text-white">NETFLIX 인기 영화</h3>
          <div class="form-group">
            <label for="sort_by" class="text-white">정렬기준:</label>
            <select id="sort_by" name="sort_by" class="form-control">
              <option value="release_date.asc">출시일 오름차순</option>
              <option value="release_date.desc">출시일 내림차순</option>
              <option value="title.asc">제목 오름차순</option>
              <option value="title.desc">제목 내림차순</option>
              <option value="original_title.asc">원제 오름차순</option>
              <option value="original_title.desc">원제 내림차순</option>
              <option value="popularity.asc">인기 오름차순</option>
              <option value="popularity.desc">인기 내림차순</option>
              <option value="vote_average.asc">평균 평점 오름차순</option>
              <option value="vote_average.desc">평균 평점 내림차순</option>
              <option value="vote_count.asc">평점 수 오름차순</option>
              <option value="vote_count.desc">평점 수 내림차순</option>
            </select>
          </div>
          <h2 class="text-white">인기 영화 목록</h2>
          <c:if test="${not empty error}">
              <p style="color: red;">${error}</p>
          </c:if>
          <c:if test="${not empty movies}">
              <table id="movieTable" class="table table-dark table-bordered">
                  <thead>
                      <tr>
                          <th>포스터</th>
                          <th>이름</th>
                          <th>줄거리</th>
                          <th>평균평점</th>
                          <th>평점합계</th>
                          <th>흥행도</th>
                          <th>출시일</th>
                          <th>언어</th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="movie" items="${movies}">
                          <tr>
                              <td><img src="https://image.tmdb.org/t/p/w500${movie.poster_path}" alt="${movie.title}" class="img-fluid"/></td>
                              <td>${movie.title}</td>
                              <td class="truncate overview-column">${movie.overview}</td>
                              <td>${movie.vote_average}</td>
                              <td>${movie.vote_count}</td>
                              <td>${movie.popularity}</td>
                              <td>${movie.release_date}</td>
                              <td>${movie.original_language}</td>
                          </tr>
                      </c:forEach>
                  </tbody>
              </table>
          </c:if>
        </section>
      </div>
    </div>
  </main>
  <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
