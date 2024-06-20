package com.webflix.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webflix.comm.JdbcConnectUtil;

public class UserDAO {
    private static UserDAO instance;
    private Connection con;

    private UserDAO() {
        // JDBC 연결 설정 초기화
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

    public boolean addUser(UserDTO user) throws SQLException {
        String query = "INSERT INTO users (user_id, name, birthdate, gender, nickname, password, phone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, user.getUserId());
            pstmt.setString(2, user.getName());
            pstmt.setDate(3, java.sql.Date.valueOf(user.getBirthDate()));
            pstmt.setString(4, user.getGender().name());
            pstmt.setString(5, user.getNickname());
            pstmt.setString(6, user.getPassword());
            pstmt.setString(7, user.getPhoneNumber());
            pstmt.setString(8, user.getEmail());
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    public UserDTO findUserById(String userId) throws SQLException {
        String query = "SELECT * FROM users WHERE user_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    UserDTO user = new UserDTO();
                    user.setUserId(rs.getString("user_id"));
                    user.setName(rs.getString("name"));
                    user.setBirthDate(rs.getDate("birthdate").toString());
                    user.setGender(UserDTO.Gender.valueOf(rs.getString("gender")));
                    user.setNickname(rs.getString("nickname"));
                    user.setPassword(rs.getString("password"));
                    user.setPhoneNumber(rs.getString("phone"));
                    user.setEmail(rs.getString("email"));
                    return user;
                }
            }
        }
        return null;
    }

    public boolean deleteUser(String userId) throws SQLException {
        String query = "DELETE FROM users WHERE user_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, userId);
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    public boolean authenticateUser(String userId, String password) throws SQLException {
        String query = "SELECT password FROM users WHERE user_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, userId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String dbPassword = rs.getString("password");
                    return dbPassword.equals(password);
                }
            }
        }
        return false;  
    }

    // 운영자 목록 가져오기
    public List<UserDTO> getAdmins() throws SQLException {
        String query = "SELECT * FROM users WHERE (name = '남기정' AND gender = 'M') OR (name = '양민지' AND gender = 'F') OR (name = '이동준' AND gender = 'M')";
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            List<UserDTO> admins = new ArrayList<>();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("user_id"));
                user.setName(rs.getString("name"));
                user.setBirthDate(rs.getDate("birthdate").toString());
                user.setGender(UserDTO.Gender.valueOf(rs.getString("gender")));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setPhoneNumber(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                admins.add(user);
            }
            return admins;
        }
    }

    // 이용자 목록 가져오기
    public List<UserDTO> getUsers() throws SQLException {
        String query = "SELECT * FROM users WHERE NOT ((name = '남기정' AND gender = 'M') OR (name = '양민지' AND gender = 'F') OR (name = '이동준' AND gender = 'M'))";
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            List<UserDTO> users = new ArrayList<>();
            while (rs.next()) {
                UserDTO user = new UserDTO();
                user.setUserId(rs.getString("user_id"));
                user.setName(rs.getString("name"));
                user.setBirthDate(rs.getDate("birthdate").toString());
                user.setGender(UserDTO.Gender.valueOf(rs.getString("gender")));
                user.setNickname(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setPhoneNumber(rs.getString("phone"));
                user.setEmail(rs.getString("email"));
                users.add(user);
            }
            return users;
        }
    }

    // 게시판 데이터 가져오기
    public List<UserDTO> getAllArticles() throws SQLException {
        String query = "SELECT * FROM board";
        try (PreparedStatement pstmt = con.prepareStatement(query); ResultSet rs = pstmt.executeQuery()) {
            List<UserDTO> articles = new ArrayList<>();
            while (rs.next()) {
                UserDTO article = new UserDTO();
                article.setBoardId(rs.getString("board_id"));
                article.setTitle(rs.getString("title"));
                article.setContent(rs.getString("content"));
                article.setCreatedAt(rs.getTimestamp("created_at"));
                article.setUserId(rs.getString("user_id"));
                articles.add(article);
            }
            return articles;
        }
    }
}

