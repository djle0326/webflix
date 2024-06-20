package com.webflix.service.api.Movie;

import org.json.simple.JSONArray;

import com.webflix.service.MovieService;

public class TmdbMovieService implements MovieService {
	
    private MovieHttpRequest httpRequest;
    private MovieJsonParser jsonParser;
    
    public TmdbMovieService(MovieHttpRequest httpRequest, MovieJsonParser jsonParser) {
        this.httpRequest = httpRequest;
        this.jsonParser = jsonParser;
    }
	
	@Override
	public JSONArray getSortedMovies(String sortBy) throws Exception {
        String jsonResponse = httpRequest.getSortedMoviesJson(sortBy);
        return jsonParser.parseMovies(jsonResponse);
	}
	
}
