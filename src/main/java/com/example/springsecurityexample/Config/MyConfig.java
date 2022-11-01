package com.example.springsecurityexample.Config;

import com.example.springsecurityexample.Models.Role;
import com.example.springsecurityexample.Models.MyUser;
import com.example.springsecurityexample.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@Configuration
public class MyConfig {
    @Bean
    CommandLineRunner commandLineRunner(UserService userService){
        return args -> {
            userService.saveRole(new Role( "USER"));
            userService.saveRole(new Role( "ADMIN"));
            userService.saveRole(new Role( "SUPERADMIN"));

            MyUser a=new MyUser( "kid","adam123",
                    "qwerty", new ArrayList<>());
            userService.saveUser(a);
            MyUser b=new MyUser("kudi","kudi123",
                    "qwerty", new ArrayList<>());
            userService.saveUser(b);

            userService.assignRole("adam123","USER");
            userService.assignRole("kudi123","USER");
            userService.assignRole("kudi123","ADMIN");
        };
    }
}

