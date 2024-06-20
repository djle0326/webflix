package com.webflix.model;

import java.time.LocalDate;

public class UserDTO {

    public enum Gender {
        M, F, O  
    }
    
    private String userId;
    private String name;
    private LocalDate birthDate;
    private Gender gender;  
    private String nickname;
    private String password;
    private String phone;
    private String email;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate string) {
        this.birthDate = string;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDTO [userId=" + userId + ", name=" + name + ", birthDate=" + birthDate + ", gender=" + gender + ", nickname=" + nickname + ", password=" + password + ", phone=" + phone + ", email=" + email + "]";
    }
}
