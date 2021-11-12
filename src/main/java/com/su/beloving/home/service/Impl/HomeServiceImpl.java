package com.su.beloving.home.service.Impl;

import com.su.beloving.home.dao.FlowerDao;
import com.su.beloving.home.entity.Flower;
import com.su.beloving.home.service.HomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {
    private final FlowerDao flowerDao;
    @Override
    public List<Flower> show(String message) {
        if (message == null || message.isEmpty()) {
            log.info("展示所有商品");
            return flowerDao.selectAll();
        }
        else {
            log.info("展示标签为'{}'的商品",message);
        }
        return flowerDao.select(message);
    }

    @Override
    public Flower selectOne(int id) {
        log.info("查询id为{}的flower",id);
        return flowerDao.selectOne(id);
    }
}
