package com.webflix.controller.mainpage;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import com.webflix.controller.Controller;
import com.webflix.controller.View;
import com.webflix.service.MovieService;
import com.webflix.service.api.ApiHttpRequest;
import com.webflix.service.api.JsonParser;
import com.webflix.service.api.TmdbApi;
import com.webflix.service.api.TmdbMovieService;

public class MainPage implements Controller {
    private MovieService movieService;

    public MainPage() {
        this.movieService = new TmdbApi(new ApiHttpRequest(), new JsonParser());
    }

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        try {
            JSONArray movies = movieService.getMovies();
            model.put("movies", movies);
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error", "Unable to fetch movies");
        }
        return "index";
    }	
}
