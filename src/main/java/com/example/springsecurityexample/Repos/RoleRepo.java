package com.example.springsecurityexample.Repos;

import com.example.springsecurityexample.Models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);
}
