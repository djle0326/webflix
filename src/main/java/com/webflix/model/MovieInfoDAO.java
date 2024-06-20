package com.webflix.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webflix.comm.JdbcConnectUtil;

public class MovieInfoDAO {
    private static MovieInfoDAO instance;
    private Connection con;

    private MovieInfoDAO() {
        this.con = JdbcConnectUtil.getConnection();
    }

    public static MovieInfoDAO getInstance() {
        if (instance == null) {
            synchronized (MovieInfoDAO.class) {
                if (instance == null) {
                    instance = new MovieInfoDAO();
                }
            }
        }
        return instance;
    }

    public boolean addMovie(MovieInfoDTO movie) throws SQLException {
        String query = "INSERT INTO movie_info (movie_id, title, release_date, summary, see_num, likes, image_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, movie.getM_ID());
            pstmt.setString(2, movie.getM_name());
            pstmt.setDate(3, java.sql.Date.valueOf(movie.getM_release_date()));
            pstmt.setString(4, movie.getM_summary());
            pstmt.setInt(5, 0);  // see_num 초기값
            pstmt.setInt(6, 0);  // likes 초기값
            pstmt.setString(7, movie.getImagePath());
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    public List<MovieInfoDTO> getTop8Movies() throws SQLException {
        String query = "SELECT movie_id, title, image_path FROM movie_info LIMIT 8";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<MovieInfoDTO> movies = new ArrayList<>();
            while (rs.next()) {
                MovieInfoDTO movie = new MovieInfoDTO();
                movie.setM_ID(rs.getString("movie_id"));
                movie.setM_name(rs.getString("title"));
                movie.setImagePath(rs.getString("image_path"));
                movies.add(movie);
            }
            return movies;
        }
    }

    public List<MovieInfoDTO> getAllMovies() throws SQLException {
        String query = "SELECT movie_id, title, release_date, summary, image_path FROM movie_info";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<MovieInfoDTO> movies = new ArrayList<>();
            while (rs.next()) {
                MovieInfoDTO movie = new MovieInfoDTO();
                movie.setM_ID(rs.getString("movie_id"));
                movie.setM_name(rs.getString("title"));
                movie.setM_release_date(rs.getDate("release_date").toLocalDate());
                movie.setM_summary(rs.getString("summary"));
                movie.setImagePath(rs.getString("image_path"));
                movies.add(movie);
            }
            return movies;
        }
    }
}
