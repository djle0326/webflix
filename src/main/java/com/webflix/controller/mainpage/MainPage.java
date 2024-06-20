package com.webflix.controller.mainpage;

import com.webflix.controller.Controller;
import com.webflix.controller.ModelAndView;
import com.webflix.model.MovieInfoDAO;
import com.webflix.model.MovieInfoDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MainPage implements Controller {
    @Override
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        ModelAndView mv = new ModelAndView("index");
        try {
            MovieInfoDAO movieDAO = MovieInfoDAO.getInstance();
            List<MovieInfoDTO> movies = movieDAO.getTop8Movies();
            mv.addObject("movies", movies);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new ModelAndView("main");
    }
}
