package com.webflix.controller.signin;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLEncoder;
import com.webflix.model.UserDAO;
import com.webflix.model.UserDTO;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.servlet.annotation.WebServlet;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        UserDTO user = new UserDTO();
        user.setName(request.getParameter("name"));
        user.setBirthDate(LocalDate.parse(request.getParameter("birthDate")));
        user.setGender(UserDTO.Gender.valueOf(request.getParameter("gender")));
        user.setNickname(request.getParameter("nickname"));
        user.setUserId(request.getParameter("userId"));
        user.setPassword(request.getParameter("password"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));

        UserDAO userDao = UserDAO.getInstance();
        boolean result = false;
        try {
            result = userDao.addUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "DB 오류 발생: " + e.getMessage());
            request.getRequestDispatcher("/views/registerError.jsp").forward(request, response);
            return;
        }

        if (result) {
            HttpSession session = request.getSession();
            session.setAttribute("isLoggedIn", true);
            session.setAttribute("userName", user.getName());
            session.setAttribute("userId", user.getUserId());
            String encodedName = URLEncoder.encode(user.getName(), "UTF-8");
            response.sendRedirect("/webflix/registerSuccess?name=" + encodedName);
        } else {
            request.setAttribute("message", "회원가입 실패. 다시 시도해주세요.");
            request.getRequestDispatcher("/views/registerError.jsp").forward(request, response);
        }
    }
}
