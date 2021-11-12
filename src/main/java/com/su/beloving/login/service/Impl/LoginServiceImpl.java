package com.su.beloving.login.service.Impl;

import com.su.beloving.login.dao.ManagerDao;
import com.su.beloving.login.dao.UserDao;
import com.su.beloving.login.entity.Manager;
import com.su.beloving.login.entity.User;
import com.su.beloving.login.service.LoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final UserDao userDao;
    private final ManagerDao managerDao;

    @Override
    public boolean login(String username, String password, int role) {
        log.info("username={},password={}",username,password);
        if (role == 0) {
            User user = userDao.selectup(username, password);
            log.info("用户登录");

            return user != null;
        } else if (role == 1) {
            Manager manager = managerDao.selectup(username, password);
            log.info("管理员登录");
            return manager != null;
        }
        return false;
    }

    @Override
    public boolean register(String username, String password, String phone, String email, int role) {
        log.info("username={},password={},phone={},email={}",username,password,phone,email);
        if (role == 0) {
            log.info("用户注册");
            User user1 = userDao.selectUsername(username);
            //用户名不可重名
            if (user1 != null) return false;
            else {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setPhone(phone);
                user.setEmail(email);
                userDao.insert(user);
            }
            return true;
        } else if (role == 1) {
            log.info("管理员注册");
            Manager manager1 = managerDao.selectUsername(username);
            //用户名不可重名
            if (manager1 != null) return false;
            else {
                Manager manager = new Manager();
                manager.setUsername(username);
                manager.setPassword(password);
                manager.setPhone(phone);
                manager.setEmail(email);
                managerDao.insert(manager);
            }
            return true;
        }
        return false;
    }
}
