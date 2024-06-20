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

    private  MovieInfoDAO() {
        // JDBC 연결 설정 초기화
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

    // 영화 정보 추가 메서드
    public boolean addMovie(MovieInfoDTO movie) throws SQLException {
        String query = "INSERT INTO movie (movie_id, movie_name, movie_img, movie_comment, movie_explain) VALUES (?,?,?,?,?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, movie.getM_ID());
            pstmt.setString(2, movie.getM_name());
            pstmt.setString(3, movie.getM_img());
            pstmt.setString(4, movie.getM_comment());
            pstmt.setString(5, movie.getM_explain());
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    // 영화 ID로 영화 조회 메서드
    public MovieInfoDTO findMovieById(String movieId) throws SQLException {
        String query = "SELECT * FROM movie WHERE movie_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, movieId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    MovieInfoDTO movie = new MovieInfoDTO();
                    movie.setM_ID(rs.getString("movie_id"));
                    movie.setM_name(rs.getString("movie_name"));
                    movie.setM_img(rs.getString("movie_img"));
                    movie.setM_comment(rs.getString("movie_comment"));
                    movie.setM_explain(rs.getString("movie_explain"));
                    return movie;
                }
            }
        }
        return null;
    }

    // 영화 ID로 영화 삭제 메서드
    public boolean deleteMovie(String movieId) throws SQLException {
        String query = "DELETE FROM movie WHERE movie_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, movieId);
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    // 모든 영화 정보를 가져오는 메서드
    public List<MovieInfoDTO> getAllMovies() throws SQLException {
        String query = "SELECT * FROM movie";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<MovieInfoDTO> movies = new ArrayList<>();
            while (rs.next()) {
                MovieInfoDTO movie = new MovieInfoDTO();
                movie.setM_ID(rs.getString("movie_id"));
                movie.setM_name(rs.getString("movie_name"));
                movie.setM_img(rs.getString("movie_img"));
                movie.setM_comment(rs.getString("movie_comment"));
                movie.setM_explain(rs.getString("movie_explain"));
                movie.setM_see_num(rs.getInt("movie_see_num"));
                movie.setM_likes(rs.getInt("movie_likes")); 
                movies.add(movie);
            }
            return movies;
        }
    }
}
