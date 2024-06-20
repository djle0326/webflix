package com.webflix.service;

import org.json.simple.JSONArray;

public interface MovieService {
	JSONArray getSortedMovies(String sortBy) throws Exception;
}
