package com.webflix.controller.mainpage;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webflix.controller.Controller;
import com.webflix.controller.View;

public class MainPage implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		
		String name = "테스트 ";
		model.put("indexName", name);
		return "index";
	}

	

	
}
