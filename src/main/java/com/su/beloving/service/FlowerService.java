package com.su.beloving.service;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.po.Flower;

import java.util.List;

public interface FlowerService {

    /**
     * 修改商品信息
     *
     * @param flower
     * @return
     */
    int updateFlower(Flower flower) throws ArgumentsIllegalException;

    /**
     * 新增商品
     *
     * @param flower
     * @return
     */
    int insertFlower(Flower flower) throws ArgumentsIllegalException;

    /**
     * 删除商品
     *
     * @param id
     * @return
     */
    int deleteFlower(Integer id) throws ArgumentsIllegalException;

    /**
     * 展示商品
     *
     * @return List<Flower></>
     */
    List<Flower> showFlower(String message) throws NoResultsException;

    /**
     * 商品详情
     *
     * @param id 花的id
     * @return Flower
     */
    Flower selectById(int id) throws ArgumentsIllegalException;
}
