package com.webflix.controller.admin;

import com.webflix.controller.Controller;
import com.webflix.controller.View;
import com.webflix.model.UserDAO;
import com.webflix.model.UserDTO;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class adminPage implements Controller {

    @Override
    public View process(HttpServletRequest request, HttpServletResponse response) {
        UserDAO userDAO = UserDAO.getInstance();
        
        try {
            List<UserDTO> admins = userDAO.getAdmins();
            List<UserDTO> users = userDAO.getUsers();
            List<UserDTO> allArticles = userDAO.getAllArticles();
            
            // 데이터를 request 객체에 설정하여 JSP에서 사용할 수 있도록 합니다.
            request.setAttribute("admins", admins);
            request.setAttribute("users", users);
            request.setAttribute("allArticles", allArticles);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new View("/WEB-INF/views/adminPage.jsp");
    }
}

