package com.webflix.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webflix.model.MovieInfoDAO;
import com.webflix.model.MovieInfoDTO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/movieTalk")
public class MovieInfo extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            MovieInfoDAO movieDAO = MovieInfoDAO.getInstance();
            List<MovieInfoDTO> movies = movieDAO.getAllMovies(); 
            request.setAttribute("movies", movies);
            request.getRequestDispatcher("/movie_info.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}
