package com.webflix.controller.signup;

import java.util.Map;

import com.webflix.controller.Controller;

public class SignUp implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "signup-form";
	}

}
