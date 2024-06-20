package com.webflix.service.api.Drama;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DramaJsonParser {

    public JSONArray parseDramas(String jsonResponse) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(jsonResponse);
        JSONArray results = (JSONArray) jsonObject.get("results");

        // Extract necessary fields
        JSONArray detailedResults = new JSONArray();
        for (int i = 0; i < results.size(); i++) {
            JSONObject drama = (JSONObject) results.get(i);
            JSONObject detailedDrama = new JSONObject();
            detailedDrama.put("original_language", drama.get("original_language"));
            detailedDrama.put("name", drama.get("name"));
            detailedDrama.put("overview", drama.get("overview"));
            detailedDrama.put("popularity", drama.get("popularity"));
            detailedDrama.put("poster_path", drama.get("poster_path"));
            detailedDrama.put("first_air_date", drama.get("first_air_date"));
            detailedDrama.put("vote_average", drama.get("vote_average"));
            detailedDrama.put("vote_count", drama.get("vote_count"));
            detailedResults.add(detailedDrama);
            
            
            
        }
        
        return detailedResults;
    }
}
