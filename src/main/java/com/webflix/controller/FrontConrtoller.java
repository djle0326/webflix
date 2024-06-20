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

@WebServlet(name =  "frontController", urlPatterns = "/webflix/*")
public class FrontConrtoller extends HttpServlet{

	private Map<String, Controller> uriMap = new HashMap<>();
	
	
	public FrontConrtoller() {
		uriMap.put("/webflix", new MainPage());
		uriMap.put("/webflix/login", new LoginForm());
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
		
		Map<String, String> paramMap = createParamMap(request);  
		ModelAndView mv = controller.process(paramMap); 
		
		String viewName = mv.getViewName();
		View view = viewResolver(viewName);
		view.render(mv.getModel(), request, response);
		 	
	}

	private View viewResolver(String viewName) {
		return new View("/WEB/INF/views" + viewName + ".jsp");
	}
	
	//request.getParameterNames를 통해 값을 전부 꺼낸 후 paramMap에 넣어둔다 
	private Map<String, String> createParamMap(HttpServletRequest request) {
		Map<String, String> paramMap = new HashMap<>();
		request.getParameterNames().asIterator().forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
		return paramMap;
	}
}
