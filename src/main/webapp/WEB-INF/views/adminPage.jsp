<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Admin Page</title>
    <style>
        body {
            background-color: #d3d3d3;
        }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1 href="src/main/webapp/WEB-INF/views/index.jsp">WEBFLIX</h1>

    <h2>운영자 목록</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Birth Date</th>
            <th>Gender</th>
            <th>Nickname</th>
            <th>User ID</th>
            <th>Phone Number</th>
            <th>Email</th>
        </tr>
        <c:forEach var="admin" items="${admins}">
            <tr>
                <td>${admin.name}</td>
                <td>${admin.birthDate}</td>
                <td>${admin.gender}</td>
                <td>${admin.nickname}</td>
                <td>${admin.userId}</td>
                <td>${admin.phoneNumber}</td>
                <td>${admin.email}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>이용자 목록</h2>
    <table>
        <tr>
            <th>Name</th>
            <th>Birth Date</th>
            <th>Gender</th>
            <th>Nickname</th>
            <th>User ID</th>
            <th>Phone Number</th>
            <th>Email</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.name}</td>
                <td>${user.birthDate}</td>
                <td>${user.gender}</td>
                <td>${user.nickname}</td>
                <td>${user.userId}</td>
                <td>${user.phoneNumber}</td>
                <td>${user.email}</td>
            </tr>
        </c:forEach>
    </table>

    <h2>게시판 목록</h2>
    <table>
        <tr>
        	<th>Board ID</th>
            <th>Title</th>
            <th>Content</th>
            <th>Created At</th>
            <th>User ID</th>
        </tr>
        <c:forEach var="article" items="${articles}">
            <tr>
            	<td>${article.boardId}</td>
                <td>${article.title}</td>
                <td>${article.content}</td>
                <td>${article.createdAt}</td>
                <td>${article.userId}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
