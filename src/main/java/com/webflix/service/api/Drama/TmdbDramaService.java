package com.webflix.service.api.Drama;

import org.json.simple.JSONArray;

import com.webflix.service.DramaService;
import com.webflix.service.api.Movie.MovieJsonParser;

public class TmdbDramaService implements DramaService {
	
    private DramaHttpRequest httpRequest;
    private DramaJsonParser jsonParser;
    
    public TmdbDramaService(DramaHttpRequest httpRequest, DramaJsonParser dramaJsonParser) {
        this.httpRequest = httpRequest;
        this.jsonParser = dramaJsonParser;
    }

	@Override
	public JSONArray getSortedDramas(String sortBy) throws Exception {
        String jsonResponse = httpRequest.getSortedDramasJson(sortBy);
        return jsonParser.parseDramas(jsonResponse);
	}
	
}
