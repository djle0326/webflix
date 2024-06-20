package com.webflix.service;

import org.json.simple.JSONArray;

public interface DramaService {
	JSONArray getSortedDramas(String sortBy) throws Exception;
}
