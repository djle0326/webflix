package com.webflix.model;

public class BoardDTO {
    private String boardId;
    private String title;
    private String content;
    private String userId;

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BoardDTO [boardId=" + boardId + ", title=" + title + ", content=" + content + ", userId=" + userId + "]";
    }
}
