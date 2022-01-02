package com.su.beloving.service;


import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.dto.OrderDetail;
import com.su.beloving.po.Order;

import java.util.List;

public interface OrderService {
    /**
     * 生成订单
     *
     * @param order
     * @return
     */
    int insertOrder(Integer userId,Integer flowerId,Integer money,String oaddress,Integer pay) throws ArgumentsIllegalException;

    /**
     * 展示订单
     */
    List<Order> showOrder(String message) throws NoResultsException;

    /**
     * 删除订单
     */
    int deleteOrder(int id) throws ArgumentsIllegalException;

    /**
     * 支付订单
     */
    int payOrder(int id) throws ArgumentsIllegalException;

    /**
     * 通过用户id查询订单
     * @param userId 用户名
     * @return
     * @throws ArgumentsIllegalException
     * @throws NoResultsException
     */
    List<OrderDetail> selectOrder(Integer userId) throws ArgumentsIllegalException,NoResultsException;

}
