package com.su.beloving.login.service;

import com.su.beloving.login.entity.User;

public interface loginService {
    //数据库中是否有此用户
    int login(String username,String password);
    //注册
    int register(User user);
}
