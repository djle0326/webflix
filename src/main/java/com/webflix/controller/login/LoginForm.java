package com.webflix.controller.login;

import com.webflix.controller.Controller;
import com.webflix.controller.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginForm implements Controller {
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
    	return new ModelAndView("login");
    }

}
