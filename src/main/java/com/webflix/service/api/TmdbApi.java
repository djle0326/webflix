package com.webflix.service.api;


import org.json.simple.JSONArray;

import com.webflix.service.IndexService;
import com.webflix.service.api.Movie.MovieJsonParser;

public class TmdbApi implements IndexService{
	
    private ApiHttpRequest httpRequest;
    private IndexJsonParser jsonParser;

    public TmdbApi(ApiHttpRequest httpRequest, IndexJsonParser jsonParser) {
        this.httpRequest = httpRequest;
        this.jsonParser = jsonParser;
    }
	
	@Override
	public JSONArray getMovies() throws Exception {
        String jsonResponse = httpRequest.getTopMoviesJson();
        return jsonParser.parseMovies(jsonResponse);
	}
	
}
