package com.webflix.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webflix.comm.JdbcConnectUtil;

public class CommentDAO {
    private static CommentDAO instance;
    private Connection con;

    private CommentDAO() {
        this.con = JdbcConnectUtil.getConnection();
    }

    public static CommentDAO getInstance() {
        if (instance == null) {
            synchronized (CommentDAO.class) {
                if (instance == null) {
                    instance = new CommentDAO();
                }
            }
        }
        return instance;
    }

    public List<CommentDTO> getMovieComments() throws SQLException {
        String query = "SELECT c.comment_id, c.content, u.name as userName, c.created_at, c.views, c.likes " +
                       "FROM comment c JOIN users u ON c.user_id = u.user_id";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<CommentDTO> comments = new ArrayList<>();
            while (rs.next()) {
                CommentDTO comment = new CommentDTO();
                comment.setCommentId(rs.getString("comment_id"));
                comment.setContent(rs.getString("content"));
                comment.setUserName(rs.getString("userName"));
                comment.setCreatedAt(rs.getTimestamp("created_at"));
                comment.setViews(rs.getInt("views"));
                comment.setLikes(rs.getInt("likes"));
                comments.add(comment);
            }
            return comments;
        }
    }
}
