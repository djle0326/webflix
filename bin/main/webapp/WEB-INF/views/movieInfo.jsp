<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table {
	border-right: none; border-left: none; border-top: none; border-bottom: none;
	background: #1E1E1E;
	width: 100%;
	
	}
	thead {
		color: white;
	}	
	tbody {
		background: #C02830;
		text-align: center;
		color: black;
		border-right: none; border-left: none;
	}
</style>
</head>
<body>
	<article>
		<article>
			<h3>영화수다(자유게시판)</h3>
		</article>
		<section>
			<table>
	    		<thead>
			        <tr>
			            <th>N번째 게시글</th>
			            <th>제목</th>
			            <th>게시자</th>
			            <th>게시날짜</th>
			            <th>조회수</th>
			            <th>좋아요수</th>
			        </tr>
			    </thead>
			    <tbody>
			        <c:forEach var="movie" items="${movies}">
				        <tr>
				            <td>${movie.m_ID}</td>
				            <td>${movie.m_name}</td>
				            <td>${movie.m_comment}</td>
				            <td>${movie.m_explain}</td>
				            <td>${movie.m_see_num}</td>
				            <td>${movie.m_likes}</td>
				        </tr>
			        </c:forEach>
	    		</tbody>
	    	</table>
		</section>
	</article>
</body>
</html>
