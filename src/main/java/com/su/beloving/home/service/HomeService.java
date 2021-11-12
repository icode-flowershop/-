package com.su.beloving.home.service;

import com.su.beloving.home.entity.Flower;

import java.util.List;

public interface HomeService {

    /**
     * 展示页面
     * @return List<Flower></>
     */
    List<Flower> show(String message);

    /**
     * 商品详情
     * @param id
     * @return Flower
     */
    Flower selectOne(int id);


}
