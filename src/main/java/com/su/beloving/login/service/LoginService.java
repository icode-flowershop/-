package com.su.beloving.login.service;


public interface LoginService {
    //登录
    boolean login(String username,String password,int role);
    //注册
    boolean register(String username, String password,String phone,String email,int role);

}
