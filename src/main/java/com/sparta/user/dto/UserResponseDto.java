package com.sparta.user.dto;

import com.sparta.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String userid;
    private String name;
    private String email;
    private String password;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.userid = user.getUserid();
        this.name = user.getName();
        this.email = user.getEmail();
        this.password = user.getPassword();

    }

}