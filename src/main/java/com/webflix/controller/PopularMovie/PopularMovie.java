package com.webflix.controller.PopularMovie;

import java.util.Map;

import org.json.simple.JSONArray;

import com.webflix.controller.Controller;
import com.webflix.service.MovieService;
import com.webflix.service.api.Movie.MovieJsonParser;
import com.webflix.service.api.Movie.MovieHttpRequest;
import com.webflix.service.api.Movie.TmdbMovieService;





public class PopularMovie implements Controller{
	private MovieService movieService;
	
    public PopularMovie() {
        this.movieService = new TmdbMovieService(new MovieHttpRequest(), new MovieJsonParser());
    }
    
	@Override
	public String process(Map<String, String> paramMap, Map<String, Object> model) {
        String sortBy = paramMap.getOrDefault("sort_by", "popularity.desc");
        try {
            JSONArray movies = movieService.getSortedMovies(sortBy);
            model.put("movies", movies);
        } catch (Exception e) {
            e.printStackTrace();
            model.put("error", "Unable to fetch movies");
        }
        return "popular-movie";
    }
	

}
