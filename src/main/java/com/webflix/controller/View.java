package com.webflix.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class View {
	
	private String viewPath;

	
	public View(String viewPath) {
		this.viewPath = viewPath;
	}
	
	//view를 출력하게끔 하는 Method
	public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}

	//model에 있는 값을 request.setAttribute에 다 담은 후 forward하는 Method
	public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		model.forEach((key, value) -> request .setAttribute(key, value)); //모델을 forEach로 다 꺼내서 -> request(key,value로)값을 전부 담아둔다.(model to request.setAttribute)
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
		dispatcher.forward(request, response);
	}
}
