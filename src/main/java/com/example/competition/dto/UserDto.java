package com.example.competition.dto;

public class UserDto {
    private String email;
    private String password;
    private String nickname;

    // 기본 생성자
    public UserDto() {
    }

    // 모든 필드를 포함한 생성자
    public UserDto(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    // Getter 및 Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
