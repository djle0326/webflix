package com.webflix.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
