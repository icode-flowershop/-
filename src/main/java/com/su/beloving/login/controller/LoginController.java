package com.su.beloving.login.controller;

import com.su.beloving.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/beloving")
@RequiredArgsConstructor
public class LoginController {
    private final LoginService loginService;

    @GetMapping("/login")
    public boolean login(@RequestParam String username, @RequestParam String password, @RequestParam int role) {
        return loginService.login(username, password, role);
    }

    @GetMapping("/register")
    public boolean register(@RequestParam String username, @RequestParam String password,
                            @RequestParam String phone, @RequestParam String email, @RequestParam int role) {
        return loginService.register(username, password, phone, email, role);
    }
}
