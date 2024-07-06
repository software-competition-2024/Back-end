package com.example.competition.config;

import com.example.competition.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfig {

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil(); // JwtUtil의 생성자가 적절하게 정의되었는지 확인하세요.
    }
}
