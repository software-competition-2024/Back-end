package com.example.competition.service;

import com.example.competition.exception.UserAlreadyExistException;
import com.example.competition.model.User;
import com.example.competition.dto.UserDto;
import com.example.competition.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.emptyList());
    }

    public User registerNewUserAccount(UserDto userDto) {
        if (userRepository.findByEmail(userDto.getEmail()) != null) {
            throw new UserAlreadyExistException("There is an account with that email address: " + userDto.getEmail());
        }
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setNickname(userDto.getNickname());
        return userRepository.save(user);
    }
}
