package com.sparta.user.controller;

import com.sparta.user.dto.UserRequestDto;
import com.sparta.user.dto.UserResponseDto;
import com.sparta.user.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     //@param id
     */
    @GetMapping("/user/{userid}")
    public UserResponseDto getUserInfo(@PathVariable Long userid, @RequestBody UserRequestDto requestDto) {
        return userService.findUser(userid, requestDto);
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/user")
    public List<UserResponseDto> getUserList() {
        return userService.findAllUser();
    }



}