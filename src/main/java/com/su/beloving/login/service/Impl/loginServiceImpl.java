package com.su.beloving.login.service.Impl;

import com.su.beloving.login.dao.UserDao;
import com.su.beloving.login.entity.User;
import com.su.beloving.login.service.loginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class loginServiceImpl implements loginService {
    private final UserDao userDao;

    @Override
    public int login(String username,String password) {
        return userDao.selectup(username,password);
    }

    @Override
    public int register(User user) {
        if (userDao.selectUsername(user.getUsername())==0){
           return userDao.insert(user);
        }
        return 0;
    }
}
