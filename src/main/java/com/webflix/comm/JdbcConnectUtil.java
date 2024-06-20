package com.webflix.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnectUtil {
    private static final Logger LOGGER = Logger.getLogger(JdbcConnectUtil.class.getName());
    private static final String URL = "jdbc:mysql://127.0.0.1:3308/webflix?serverTimezone=UTC&characterEncoding=utf-8&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, "Database driver not found", e);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Database connection failed", e);
        }
        return null;
    }

    public static void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "ResultSet cannot be closed", e);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "PreparedStatement cannot be closed", e);
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                LOGGER.log(Level.WARNING, "Connection cannot be closed", e);
            }
        }
    }
}
