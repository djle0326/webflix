package com.webflix.controller.api;

import java.util.Map;


import com.webflix.controller.Controller;

public class filteringStudy implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		String a = paramMap.get("selection");
		System.out.println(a);
		model.put("selection", a);
		return "index";
	}
	
	
}
