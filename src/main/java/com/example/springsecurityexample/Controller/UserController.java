package com.example.springsecurityexample.Controller;

import com.example.springsecurityexample.Models.Role;
import com.example.springsecurityexample.Models.RoleToUser;
import com.example.springsecurityexample.Models.MyUser;
import com.example.springsecurityexample.Service.UserService;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api")
@Api( tags = "users")
@RequiredArgsConstructor//instead of autowired
public class UserController {
    private final UserService userService;

    @GetMapping("users")
    public ResponseEntity<List<MyUser>> getUsers(){
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("user/save")
    public ResponseEntity<MyUser> saveUser(@RequestBody MyUser user){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        //fromCurrentContextPath() localhost
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @PostMapping ("role/save")
    public ResponseEntity<Role> saveUser(@RequestBody Role role){
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        //fromCurrentContextPath() localhost
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @PostMapping ("role/assigntouser")
    public ResponseEntity<?> assignRole(@RequestBody RoleToUser roleToUser){
        userService.assignRole(roleToUser.getUsername(), roleToUser.getRoleName());
        return ResponseEntity.ok().build();
    }




    /*@GetMapping("users/{}")
    public ResponseEntity<SystemUser> getUser(String username){
        return ResponseEntity.ok().body(userService.getUser(username));
    }*/
}
