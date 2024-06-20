package com.webflix.model;

public class MovieInfoDTO {
    private String m_ID;
    private String m_name;
    private String m_img;
    private String m_comment;
    private String m_explain;
    private int m_see_num;
    private int m_likes;

    // 기본 생성자
    public MovieInfoDTO() {
    }

    // 매개변수를 받는 생성자
    public MovieInfoDTO(String m_ID, String m_name, String m_img, String m_comment, String m_explain) {
        this.m_ID = m_ID;
        this.m_name = m_name;
        this.m_img = m_img;
        this.m_comment = m_comment;
        this.m_explain = m_explain;
    }

    public int getM_see_num() {
		return m_see_num;
	}

	public void setM_see_num(int m_see_num) {
		this.m_see_num = m_see_num;
	}

	public int getM_likes() {
		return m_likes;
	}

	public void setM_likes(int m_likes) {
		this.m_likes = m_likes;
	}

	// Getter와 Setter 메서드
    public String getM_ID() {
        return m_ID;
    }

    public void setM_ID(String m_ID) {
        this.m_ID = m_ID;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_img() {
        return m_img;
    }

    public void setM_img(String m_img) {
        this.m_img = m_img;
    }

    public String getM_comment() {
        return m_comment;
    }

    public void setM_comment(String m_comment) {
        this.m_comment = m_comment;
    }

    public String getM_explain() {
        return m_explain;
    }

    public void setM_explain(String m_explain) {
        this.m_explain = m_explain;
    }

    // toString 메서드 (디버깅용)
    @Override
    public String toString() {
        return "MovieInfoDTO [m_ID=" + m_ID + ", m_name=" + m_name + ", m_img=" + m_img + ", m_comment=" + m_comment + ", m_explain=" + m_explain+ ", m_see_num=" + m_see_num + ", m_likes=" + m_likes + "]";
    }
}
