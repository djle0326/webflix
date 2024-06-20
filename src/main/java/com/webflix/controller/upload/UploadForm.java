package com.webflix.controller.upload;

import java.util.Map;

import com.webflix.controller.Controller;

public class UploadForm implements Controller {

	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
		return "upload-from";
	}
	
	
}
