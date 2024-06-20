package com.webflix.service.api.Movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

import com.webflix.service.api.APIKEY;

public class MovieHttpRequest {
	
	private static final String BASE_URL = "https://api.themoviedb.org/3";
	private final String API_KEY = APIKEY.getApiKey();
	
    public String getSortedMoviesJson(String sortBy) throws IOException {
        String urlString = BASE_URL + "/discover/movie?include_adult=false&include_null_first_air_dates=false&language=ko-KR&page=1&sort_by=" + sortBy + "&watch_region=KR&with_watch_providers=8&api_key=" + API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.lines().collect(Collectors.joining());
        in.close();
        System.out.println("movie response: " + response);

        return response;
    }

}
