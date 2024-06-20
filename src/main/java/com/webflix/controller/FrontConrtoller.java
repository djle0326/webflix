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
import com.webflix.controller.login.LoginProcess;
import com.webflix.controller.mainpage.MainPage;

@WebServlet(name =  "frontController", urlPatterns = "/webflix/*")
public class FrontConrtoller extends HttpServlet{

	private Map<String, Controller> uriMap = new HashMap<>();
	
	
	public FrontConrtoller() {
		uriMap.put("/webflix", new MainPage());
		uriMap.put("/webflix/login", new LoginForm());
		uriMap.put("/webflix/login.do", new LoginProcess());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("FrontConrtoller.service()");
		
		String requestURI = request.getRequestURI();	
		
		Controller controller = uriMap.get(requestURI);
		if (controller == null) {
			response.setStatus(HttpServletResponse.SC_NOT_FOUND); //없으면 404 
			return;
		}
		
		Map<String, String> paramMap = createParamMap(request); //값 꺼내는 Method호출 	
		Map<String, Object> model = new HashMap<>();
		
		String viewName = controller.process(paramMap, model);
		
		View view = viewResolver(viewName);
		view.render(model, request, response);
		 	
	}

	//request.getParameterNames를 통해 값을 전부 꺼낸 후 paramMap에 넣어둔다 
	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
	
	private View viewResolver(String viewName) {
		return new View("/WEB-INF/views/" + viewName + ".jsp");
	}
	
}
