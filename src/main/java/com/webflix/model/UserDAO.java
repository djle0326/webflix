package com.webflix.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.webflix.comm.JdbcConnectUtil;

public class UserDAO {
    private static UserDAO instance;
    private Connection con;

    private UserDAO() {
        this.con = JdbcConnectUtil.getConnection();
    }

    public static UserDAO getInstance() {
        if (instance == null) {
            synchronized (UserDAO.class) {
                if (instance == null) {
                    instance = new UserDAO();
                }
            }
        }
        return instance;
    }

    public List<UserDTO> getAdmins() throws SQLException {
        String query = "SELECT * FROM users WHERE (name = '남기정' AND gender = 'M') OR (name = '양민지' AND gender = 'F') OR (name = '이동준' AND gender = 'M')";
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            List<UserDTO> admins = new ArrayList<>();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("user_id"));
                user.setName(rs.getString("name"));
                user.setBirthDate(rs.getDate("birthdate").toLocalDate());
                user.setGender(UserDTO.Gender.valueOf(rs.getString("gender")));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                admins.add(user);
            }
            return admins;
        }
    }

    public List<UserDTO> getAllArticles() throws SQLException {
        String query = "SELECT * FROM board";
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            List<UserDTO> articles = new ArrayList<>();
            while (rs.next()) {
                UserDTO article = new UserDTO();
                article.setBoardId(rs.getString("board_id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                article.setUserId(rs.getString("user_id"));
                articles.add(article);
            }
            return articles;
        }
    }

    public List<UserDTO> getUsers() throws SQLException {
        String query = "SELECT * FROM users WHERE NOT ((name = '남기정' AND gender = 'M') OR (name = '양민지' AND gender = 'F') OR (name = '이동준' AND gender = 'M'))";
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            List<UserDTO> users = new ArrayList<>();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("user_id"));
                user.setName(rs.getString("name"));
                user.setBirthDate(rs.getDate("birthdate").toLocalDate());
                user.setGender(UserDTO.Gender.valueOf(rs.getString("gender")));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            return users;
        }
    }

    public boolean addUser(UserDTO user) throws SQLException {
        if (isUserExists(user.getUserId())) {
            throw new SQLException("Duplicate entry for user ID: " + user.getUserId());
        }

        String query = "INSERT INTO users (user_id, name, birthdate, gender, nickname, password, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setDate(3, java.sql.Date.valueOf(user.getBirthDate()));
            pstmt.setString(4, user.getGender().name());
            pstmt.setString(5, user.getNickname());
            pstmt.setString(6, user.getPassword());
            pstmt.setString(7, user.getPhone());
            pstmt.setString(8, user.getEmail());
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    private boolean isUserExists(String userId) throws SQLException {
        String query = "SELECT user_id FROM users WHERE user_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                return rs.next();
            }
        }
    }
}
