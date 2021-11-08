package com.su.beloving.login.controller;

import com.su.beloving.login.entity.User;
import com.su.beloving.login.service.loginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("beloving")
@RequiredArgsConstructor
public class loginController {
    private final loginService loginService;

    @GetMapping("/login")
    public int login(String username, String password){
        return loginService.login(username,password);
    }
    @GetMapping("/register")
    public int register(User user){
        return loginService.register(user);
    }


}
