package com.webflix.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
//	View process(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException;
	ModelAndView process(Map<String, String> paramMap);
}
