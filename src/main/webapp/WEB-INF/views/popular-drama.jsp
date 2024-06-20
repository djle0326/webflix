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
        max-width: 200px; /* Adjust as necessary */
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
          url: '/webflix/popular/drama',
          type: 'GET',
          data: { sort_by: sortBy },
          success: function(data) {
            console.log('AJAX call successful'); // Debugging: Log success
            console.log('Received data:', data); // Debugging: Log received data
            $('#dramaTable tbody').html($(data).find('#dramaTable tbody').html());
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
          <h3 id="top" class="text-white">NETFLIX TOP10 드라마</h3>
          <div class="form-group">
            <label for="sort_by" class="text-white">정렬기준:</label>
            <select id="sort_by" name="sort_by" class="form-control">
              <option value="first_air_date.asc">출시일 오름차순</option>
              <option value="first_air_date.desc">출시일 내림차순</option>
              <option value="name.asc">이름 오름차순</option>
              <option value="name.desc">이름 내림차순</option>
              <option value="original_name.asc">원작명 오름차순</option>
              <option value="original_name.desc">원작명 내림차순</option>
              <option value="popularity.asc">인기 오름차순</option>
              <option value="popularity.desc">인기 내림차순</option>
              <option value="vote_average.asc">평균 추천 오름차순</option>
              <option value="vote_average.desc">평균 추천 내림차순</option>
              <option value="vote_count.asc">추천 합계 오름차순</option>
              <option value="vote_count.desc">추천 합계 내림차순</option>
            </select>
          </div>
          <h2 class="text-white">조회 결과</h2>
          <c:if test="${not empty error}">
              <p style="color: red;">${error}</p>
          </c:if>
          <c:if test="${not empty dramas}">
              <table id="dramaTable" class="table table-dark table-bordered">
                  <thead>
                      <tr>
                      	  <th>포스터 </th>
                      	  <th>제목</th>
                      	  <th>줄거리</th>
                          <th>평균평점</th>
                          <th>평점합계</th>
                          <th>흥행도</th>       
                          <th>출시일</th>    
                          <th>언어 </th>
                      </tr>
                  </thead>
                  <tbody>
                      <c:forEach var="drama" items="${dramas}">
                          <tr>
                          <td><img src="https://image.tmdb.org/t/p/w500${drama.poster_path}" alt="${drama.name}" class="img-fluid"/></td>
                              
                              <td>${drama.name}</td>
                              
                              <td class="truncate">${drama.overview}</td>
                              <td>${drama.vote_average}</td>
                              <td>${drama.vote_count}</td>
                              
                              <td>${drama.popularity}</td>
                              
                              <td>${drama.first_air_date}</td>
                              <td>${drama.original_language}</td>
                              
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
