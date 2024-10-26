package com.aarteaga.ms_user.controller;


import com.aarteaga.ms_user.config.JWTAuthenticationConfig;
import com.aarteaga.ms_user.dto.UserDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Tag(name = "User", description = "Operations for USER")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    JWTAuthenticationConfig jwtAuthtenticationConfig;

    @PostMapping("/login")
    public UserDto login(@RequestParam("user") String username, @RequestParam("pwd") String password) throws IOException {

        String token = jwtAuthtenticationConfig.getJWTToken(username);

        //TODO Validate user exist with extern API
        UserDto user = new UserDto();
        user.setUsername(username);
        user.setToken(token);

        return user;
    }

    @GetMapping("/greetings")
    public String greetings(@RequestParam(value="name", defaultValue="World") String name) {
        return "Hello {" + name + "}";
    }

}
