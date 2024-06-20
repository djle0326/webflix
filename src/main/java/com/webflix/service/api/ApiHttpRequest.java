package com.webflix.service.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class ApiHttpRequest {
    private static final String BASE_URL = "https://api.themoviedb.org/3";

    public String getTopMoviesJson() throws IOException {
        String urlString = BASE_URL + "/discover/movie?include_adult=false&include_video=false&language=ko-KR&page=1&sort_by=popularity.desc&watch_region=KR&with_watch_providers=8&api_key=" + APIKEY.TMDB_API_KEY;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String response = in.lines().collect(Collectors.joining());
        in.close();

        return response;
    }
}
