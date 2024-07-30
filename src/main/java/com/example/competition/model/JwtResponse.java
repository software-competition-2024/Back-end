package com.example.competition.model;

public class JwtResponse {
    private String jwtToken;

    // Constructor
    public JwtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    // Getter
    public String getJwtToken() {
        return jwtToken;
    }

    // Setter
    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }
}
