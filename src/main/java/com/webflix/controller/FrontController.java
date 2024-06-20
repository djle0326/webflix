package com.webflix.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webflix.controller.login.LoginForm;
import com.webflix.controller.mainpage.MainPage;

@WebServlet(name = "FrontController", urlPatterns = "/webflix/*")
public class FrontController extends HttpServlet {
    private Map<String, Controller> uriMap = new HashMap<>();

    public FrontController() {
        uriMap.put("/webflix", new MainPage());
        uriMap.put("/webflix/login", new LoginForm());
        uriMap.put("/webflix/addMovie", new AddMovieServlet());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI();
        Controller controller = uriMap.get(requestURI);
        if (controller == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        ModelAndView mv = controller.process(request, response);
        String viewName = mv.getViewName();
        View view = viewResolver(viewName);
        view.render(mv.getModel(), request, response);
    }

    private View viewResolver(String viewName) {
        return new View("/WEB-INF/views/" + viewName + ".jsp");
    }
}
