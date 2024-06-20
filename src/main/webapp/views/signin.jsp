<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>회원 가입</title>
<style>
    body {
        background-image: url("loginbg.png");
        background-size: 100% 100%;
        text-align: center;
    }
    .container {
        display: flex;
        font-size: larger;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }
    table {
        background-color: black;
        color: white;
        padding: 20pt 60pt 40pt 60pt;
        border: 3pt solid rgba(255, 255, 255, 0.5);
        border-radius: 5px;
    }
    table th, table td {
        border: 0px;
    }
    table a {
        color: rgba(255, 255, 255, 0.7);
        text-decoration: none;
    }
    #link {
        color: rgba(255, 255, 255, 0.7);
    }
    input[type=submit] {
        width: 158pt;
        font-weight: 900;
        background-color: #BA282F;
        border-radius: 5px;
    }
    #login {
        font-size: 30pt;
        padding-bottom: 5pt;
    }
    .td {
        font-size: 21pt;
        text-align: left;
    }
    #gender {
        text-align: left;
        padding-left: 15px;
    }
    input[type="text"], input[type="password"], input[type="email"] {
        width: 250pt;
        height: 25pt;
    }
    input[type="date"], input[type="button"] {
        width: 150pt;
        height: 24pt;
        font-weight: 900;
        font-size: 12pt;
        float: left;
        margin-left: 7pt;
    }
    input[type="submit"] {
        width: 360pt;
        height: 35pt;
        font-size: 20pt;
        font-weight: 900;
    }
</style>
</head>
<body>
<div class="container">
    <form action="/webflix/register" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <table>
            <tr>
                <th colspan="2" id="login">회원 가입</th>
            </tr>
            <tr>
                <th class="td">이름</th>
                <td><input type="text" name="name" required></td>
            </tr>
            <tr>
                <th class="td">생년월일</th>
                <td><input type="date" name="birthDate" required></td>
            </tr>
            <tr>
                <th class="td">성별</th>
                <td id="gender">
                    <input type="radio" name="gender" value="M" required> 남
                    <input type="radio" name="gender" value="F" required> 여
                    <input type="radio" name="gender" value="O" required> 기타
                </td>
            </tr>
            <tr>
                <th class="td">닉네임</th>
                <td><input type="text" name="nickname" required></td>
            </tr>
            <tr>
                <th class="td">ID</th>
                <td><input type="text" name="userId" required></td>
            </tr>
            <tr>
                <th class="td">PW</th>
                <td><input type="password" name="password" required></td>
            </tr>
            <tr>
                <th class="td">전화번호</th>
                <td><input type="text" name="phone" placeholder="010-0000-0000" required></td>
            </tr>
            <tr>
                <th class="td">이메일</th>
                <td><input type="email" name="email" placeholder="abcde1234@gmail.com" required></td>
            </tr>
            <tr>
                <th colspan="2"><input type="submit" value="계정생성"></th>
            </tr>
            <tr>
                <td colspan="2" id="link">[&nbsp; <a href="login-form.jsp">로그인</a>&nbsp; | &nbsp;<a href="findAccount.jsp">ID/PW 찾기</a>&nbsp; ]</td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
