package com.webflix.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webflix.comm.JdbcConnectUtil;

public class BoardDAO {
    private static BoardDAO instance;
    private Connection con;

    private BoardDAO() {
        this.con = JdbcConnectUtil.getConnection();
    }

    public static BoardDAO getInstance() {
        if (instance == null) {
            synchronized (BoardDAO.class) {
                if (instance == null) {
                    instance = new BoardDAO();
                }
            }
        }
        return instance;
    }

    public boolean addBoard(BoardDTO board) throws SQLException {
        String query = "INSERT INTO board (board_id, title, content, user_id) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, board.getBoardId());
            pstmt.setString(2, board.getTitle());
            pstmt.setString(3, board.getContent());
            pstmt.setString(4, board.getUserId());
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    public BoardDTO findBoardById(String boardId) throws SQLException {
        String query = "SELECT * FROM board WHERE board_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, boardId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    BoardDTO board = new BoardDTO();
                    board.setBoardId(rs.getString("board_id"));
                    board.setTitle(rs.getString("title"));
                    board.setContent(rs.getString("content"));
                    board.setUserId(rs.getString("user_id"));
                    return board;
                }
            }
        }
        return null;
    }

    public boolean deleteBoard(String boardId) throws SQLException {
        String query = "DELETE FROM board WHERE board_id = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, boardId);
            int result = pstmt.executeUpdate();
            return result > 0;
        }
    }

    public List<BoardDTO> getAllBoards() throws SQLException {
        String query = "SELECT * FROM board";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            List<BoardDTO> boards = new ArrayList<>();
            while (rs.next()) {
                BoardDTO board = new BoardDTO();
                board.setBoardId(rs.getString("board_id"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setUserId(rs.getString("user_id"));
                boards.add(board);
            }
            return boards;
        }
    }
}
