package com.webflix.service.api;


import org.json.simple.JSONArray;

import com.webflix.service.IndexService;
import com.webflix.service.api.Movie.MovieJsonParser;

public class TmdbMovieService implements IndexService {
	
    private ApiHttpRequest httpRequest;
    private MovieJsonParser jsonParser;

	@Override
	public JSONArray getMovies() throws Exception {
		String jsonResponse = httpRequest.getTopMoviesJson();
		
		return jsonParser.parseMovies(jsonResponse);
	}
	
}

