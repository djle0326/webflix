<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
            height: 100vh; /* 화면 전체 높이에 맞게 중앙 정렬 */
        }

        table {
            background-color: black;
            color: white;
            padding: 20pt 60pt 40pt 60pt;
            border: 3pt solid rgba(255, 255, 255,0.5);
            border-radius: 5px;
        }

        table th, table td {
            border: 0px;
        }

        table a {
            color: white;
            text-decoration: none;
            color: rgba(255, 255, 255,0.7);
        }

        #link {color: rgba(255, 255, 255,0.7);}

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
        .td {font-size: 21pt;
        text-align: left;}
        
       #gender {text-align:left; padding-left:15px}
        
        input[type="text"],input[type="password"] {width:250pt;
            height:25pt;}

        input[type="text"]::placeholder{font-size: large;}

        input[type="submit"]{ width: 360pt;
        height: 35pt;
        font-size: 20pt;
        font-weight: 900;}

        input[type="date"]{width:150pt;
            height:24pt;
            font-weight: 900;
            font-size: 12pt;
            float: left;
            margin-left: 7pt;}

        input[type="button"]{width:50pt;
            height:24pt;
            font-weight: 900;
            font-size: 12pt;
            float: left;
            margin-left: 6pt;}
        
    </style>
</head>
</head>
<body>
    <div class="container">
        <form action="RegisterController" method="POST">
            <table border="1">
                <tr>
                    <th colspan="2" id="login">회원 가입</th>
                </tr>
                <tr>
                    <th class="td">이름</th>
                    <td><input type="text" name="name"></td>
                </tr>
                <tr>
                    <th class="td">생년월일</th>
                    <td><input type="date" name="birthDate"></td>
                </tr>
                <tr>
                    <th class="td" >성별</th>
                    <td id="gender">
                        <input type="radio" name="gender" value="MALE"> 남
                        <input type="radio" name="gender" value="FEMALE"> 여
                        <input type="radio" name="gender" value="OTHER"> 기타
                    </td>
                </tr>
                <tr>
                    <th class="td">닉네임</th>
                    <td><input type="text" name="nickname"></td>
                </tr>
                <tr>
                    <th class="td">ID</th>
                    <td><input type="text" name="userId"></td>
                </tr>
                <tr>
                    <th class="td">PW</th>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <th class="td">전화번호</th>
                    <td><input type="text" name="phone" placeholder="010-0000-0000"></td>
                </tr>
                <tr>
                    <th class="td">이메일</th>
                    <td><input type="text" name="email" placeholder="abcde1234@gmail.com"></td>
                </tr>
                <tr>
                    <th colspan="2"><input type="submit" value="계정생성"></th>
                </tr>
                <tr>
                    <td colspan="2" id="link">[&nbsp; <a href="login.jsp">로그인</a>&nbsp; | &nbsp;<a href="findAccount.jsp">ID/PW 찾기</a>&nbsp; ]</td>
                </tr>
            </table>
        </form>
    </div>
</body>
</html>