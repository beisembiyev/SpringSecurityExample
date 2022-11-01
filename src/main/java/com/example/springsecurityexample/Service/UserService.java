package com.example.springsecurityexample.Service;

import com.example.springsecurityexample.Models.Role;
import com.example.springsecurityexample.Models.MyUser;

import java.util.List;

public interface UserService {
    MyUser saveUser(MyUser user);
    Role saveRole(Role role);
    void assignRole(String username, String roleName);
    MyUser getUser(String username);
    List<MyUser> getAllUsers();
}
