<<<<<<< HEAD
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
||||||| empty tree
=======
package com.webflix.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
//	View process(HttpServletRequest request, HttpServletResponse resonse) throws ServletException, IOException;
	String process(Map<String, String> paramMap, Map<String, Object> model);
}
>>>>>>> 8a2041f9832ee1aef056c9cd9bee8e299cedb51e
