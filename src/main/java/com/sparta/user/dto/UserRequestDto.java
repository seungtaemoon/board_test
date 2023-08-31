package com.sparta.user.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String userid;
    private String name;
    private String email;
    private String password;
}