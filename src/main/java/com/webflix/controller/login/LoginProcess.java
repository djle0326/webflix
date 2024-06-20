package com.webflix.controller.login;

import java.util.Map;

import com.webflix.controller.Controller;

public class LoginProcess  implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		
		
		
//		model.put("userId", userId);
//		model.put("password", password);
		
		return "index";
	}

	
	
}
