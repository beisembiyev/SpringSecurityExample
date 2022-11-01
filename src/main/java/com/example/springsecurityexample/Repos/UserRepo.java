package com.example.springsecurityexample.Repos;

import com.example.springsecurityexample.Models.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<MyUser, Long> {
    MyUser findSystemUserByUsername (String username);

}
