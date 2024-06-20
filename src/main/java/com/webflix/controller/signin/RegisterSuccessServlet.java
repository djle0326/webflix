package com.webflix.controller.signin;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import java.net.URLEncoder;

@WebServlet("/registerSuccess")
public class RegisterSuccessServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<script>");
        out.println("alert('" + name + "님 환영합니다!');");
        out.println("window.location.href = '/webflix/views/index.jsp';");
        out.println("</script>");
    }
}
