package com.webflix.service.api.Movie;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MovieJsonParser {
	
    public JSONArray parseMovies(String jsonResponse) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
        JSONArray results = (JSONArray) jsonObject.get("results");

        // Limit to top 10 movies or dramas and extract necessary fields
        JSONArray detailedResults = new JSONArray();
        for (int i = 0; i < results.size(); i++) {
            JSONObject movie = (JSONObject) results.get(i);
            JSONObject detailedMovie = new JSONObject();
            detailedMovie.put("original_language", movie.get("original_language"));
            detailedMovie.put("overview", movie.get("overview"));
            detailedMovie.put("popularity", movie.get("popularity"));
            detailedMovie.put("poster_path", movie.get("poster_path"));
            detailedMovie.put("release_date", movie.get("release_date"));
            detailedMovie.put("title", movie.get("title"));
            detailedMovie.put("vote_average", movie.get("vote_average"));
            detailedMovie.put("vote_count", movie.get("vote_count"));
            detailedResults.add(detailedMovie);
        }

        return detailedResults;
    }
    
}
