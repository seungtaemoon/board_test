package com.sparta.user.entity;

import com.sparta.user.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity // JPA가 관리할 수 있는 Entity 클래스 지정
@Getter
@Setter
@Table(name = "user") // 매핑할 테이블의 이름을 지정
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "userid", nullable = false)
    private String userid;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email", nullable = false, length = 500)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;

    public User(UserRequestDto requestDto) {
        this.userid = requestDto.getUserid();
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
    }

    public void update(UserRequestDto requestDto) {
        this.userid = requestDto.getUserid();
        this.name = requestDto.getName();
        this.email = requestDto.getEmail();
        this.password = requestDto.getPassword();
    }
}