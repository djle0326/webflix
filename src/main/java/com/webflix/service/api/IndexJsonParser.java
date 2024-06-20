package com.webflix.service.api;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class IndexJsonParser {
    public JSONArray parseMovies(String jsonResponse) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
        JSONArray results = (JSONArray) jsonObject.get("results");

        // Limit to top 10 movies
        JSONArray top10Movies = new JSONArray();
        for (int i = 0; i < 10 && i < results.size(); i++) {
            top10Movies.add(results.get(i));
        }

        return top10Movies;
    }
}
