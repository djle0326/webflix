<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>평균 평점</th>
            <th>평가 수</th>
            <th>인기도</th>
            <th>포스터</th>
        </tr>
    </thead>
    <tbody>
            <tr>
                <td></td>
            </tr>
    </tbody>
    
		<form action="/webflix/api">
        <select name="selection">
            <option value="tv">드라마 </option>
            <option value="movie">영화 </option>
        </select>
        <button>전송</button>
    </form>
</table>
</body>
</html>