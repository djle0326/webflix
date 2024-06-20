package com.webflix.model;

import java.time.LocalDate;

public class MovieInfoDTO {
    private String m_ID;
    private String m_name;
    private String imagePath;
    private LocalDate m_release_date;
    private String m_summary;

    // Getters and Setters
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public LocalDate getM_release_date() {
        return m_release_date;
    }

    public void setM_release_date(LocalDate m_release_date) {
        this.m_release_date = m_release_date;
    }

    public String getM_summary() {
        return m_summary;
    }

    public void setM_summary(String m_summary) {
        this.m_summary = m_summary;
    }

	public void setM_see_num(int i) {
		// TODO Auto-generated method stub
		
	}

	public void setM_likes(int i) {
		// TODO Auto-generated method stub
		
	}
}
