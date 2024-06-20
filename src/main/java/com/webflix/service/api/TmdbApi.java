package com.webflix.service.api;


import org.json.simple.JSONArray;

import com.webflix.service.MovieService;

public class TmdbApi implements MovieService{
	
    private ApiHttpRequest httpRequest;
    private JsonParser jsonParser;

    public TmdbApi(ApiHttpRequest httpRequest, JsonParser jsonParser) {
        this.httpRequest = httpRequest;
        this.jsonParser = jsonParser;
    }
	
	@Override
	public JSONArray getMovies() throws Exception {
        String jsonResponse = httpRequest.getTopMoviesJson();
        return jsonParser.parseMovies(jsonResponse);
	}
	
}
