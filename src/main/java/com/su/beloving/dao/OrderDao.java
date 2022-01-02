package com.su.beloving.dao;

import com.su.beloving.po.Flower;
import com.su.beloving.po.Order;
import com.su.beloving.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface OrderDao {
    /**
     * 新增订单
     *
     * @param order
     * @return
     */
    int insertOne(Order order);

    /**
     * 通过id修改订单
     *
     * @param order
     * @return
     */
    int updateOne(Order order);

    /**
     * 通过商品id查商品信息
     *
     * @param flowerId
     * @return
     */
    Flower queryFlower(Integer flowerId);

    /**
     * 通过用户id查用户信息
     *
     * @param userId
     * @return
     */
    User queryUser(Integer userId);

    /**
     * 查询所有订单
     *
     * @return
     */
    List<Order> selectAll();

    /**
     * 模糊查询订单
     *
     * @param message
     * @return
     */
    List<Order> select(String message);

    /**
     * 通过id查询订单
     *
     * @param id
     * @return
     */
    Order selectById(int id);

    /**
     * 删除订单
     */
    int deleteOne(int id);

    /**
     * 支付订单
     */
    int updatePay(int id);

    /**
     * 通过用户id查他的订单
     *
     * @param userId
     * @return
     */
    List<Order> selectByUserId(Integer userId);


}
