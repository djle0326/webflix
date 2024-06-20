package com.webflix.service.api;


import org.json.simple.JSONArray;

import com.webflix.service.MovieService;

public class TmdbMovieService implements MovieService {
	
    private ApiHttpRequest httpRequest;
    private JsonParser jsonParser;

	@Override
	public JSONArray getMovies() throws Exception {
		String jsonResponse = httpRequest.getTopMoviesJson();
		
		return jsonParser.parseMovies(jsonResponse);
	}
	
}

