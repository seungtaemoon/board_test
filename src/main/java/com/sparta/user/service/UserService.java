package com.sparta.user.service;

import com.sparta.user.dto.UserRequestDto;
import com.sparta.user.dto.UserResponseDto;
import com.sparta.user.entity.User;
import com.sparta.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }

    public UserResponseDto findUser(Long id, UserRequestDto requestDto) {
        User user = findId(id);
        if(requestDto.getUserid().equals(user.getUserid())){
            return new UserResponseDto(user);
        }
        else{
            throw new NullPointerException("아이디가 맞지 않습니다.");
        }
    }

    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    }

    private User findId (Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NullPointerException("데이터가 없습니다."));
    }

}