package com.su.beloving.manage.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.su.beloving.home.dao.FlowerDao;
import com.su.beloving.home.entity.Flower;
import com.su.beloving.login.dao.UserDao;
import com.su.beloving.login.entity.User;
import com.su.beloving.manage.service.ManageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ManageServiceImpl implements ManageService{
    private final FlowerDao flowerDao;
    private final UserDao userDao;
    @Override
    public int updateFlower(String jsonObj) {
        Flower flower= JSONObject.parseObject(jsonObj, Flower.class);
        log.info("修改id为{}的话花",flower.getId());
        return flowerDao.updateOne(flower);
    }

    @Override
    public int insertFlower(String jsonObj) {
        Flower flower=JSONObject.parseObject(jsonObj,Flower.class);
        log.info("新增{}",jsonObj);
        return flowerDao.insertOne(flower);
    }

    @Override
    public int deleteFlower(Integer id) {
        log.info("删除id为{}的数据",id);
        return flowerDao.deleteById(id);
    }

    @Override
    public int deleteUser(Integer id) {
        log.info("删除id为{}的用户",id);
        return userDao.deleteById(id);
    }

    @Override
    public List<User> showUser(String message) {
        if (message==null||message.isEmpty()){
            log.info("展示所有用户");
            return userDao.selectAll();
        }
        else {
            log.info("展示{}",message);
            return  userDao.select(message);
        }
    }
}
