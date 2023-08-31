package com.sparta.user.repository;
import com.sparta.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface UserRepository extends JpaRepository<User, Long> {

}