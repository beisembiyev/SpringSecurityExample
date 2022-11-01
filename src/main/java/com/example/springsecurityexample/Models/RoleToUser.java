package com.example.springsecurityexample.Models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RoleToUser {
    private String username;
    private String roleName;
}
