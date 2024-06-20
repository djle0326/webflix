package com.webflix.controller.signin;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import com.webflix.model.UserDAO;
import com.webflix.model.UserDTO;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // UserDTO 객체 생성
        UserDTO user = new UserDTO();
        
        String name = request.getParameter("name");
        String birthDate = request.getParameter("birthDate");
        String nickname = request.getParameter("nickname");
        String userId = request.getParameter("userId");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        // 성별 정보 설정 + 나머지 정보
        user.setGender(UserDTO.Gender.valueOf(request.getParameter("gender").toUpperCase()));

        user.setName(name);
        user.setBirthDate(birthDate);
        user.setNickname(nickname);
        user.setUserId(userId);
        user.setPassword(password);
        user.setPhone(phone);
        user.setEmail(email);

        UserDAO userDao = UserDAO.getInstance();
        boolean result = false;
        try {
            result = userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "DB 오류 발생: " + e.getMessage());
            request.getRequestDispatcher("/registerError.jsp").forward(request, response); //제작x => 공백페이지 리턴
            return; // 에러가 발생=> 더이상 진행x
        }

        String message = result ? "회원가입 성공!" : "회원가입 실패. 다시 시도해주세요.";
        request.setAttribute("message", message);
        request.getRequestDispatcher("/registerResult.jsp").forward(request, response);
    }
}
