package com.su.beloving.service.Impl;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.dao.FlowerDao;
import com.su.beloving.dao.OrderDao;
import com.su.beloving.dao.UserDao;
import com.su.beloving.dto.OrderDetail;
import com.su.beloving.po.Flower;
import com.su.beloving.po.Order;
import com.su.beloving.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Accessors(chain = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final UserDao userDao;
    private final OrderDao orderDao;
    private final FlowerDao flowerDao;

    @Override
    public int insertOrder(Integer userId, Integer flowerId, Integer money, String oaddress, Integer pay) throws ArgumentsIllegalException {
        Order order = new Order();
        order.setUserId(userId);
        order.setFlowerId(flowerId);
        order.setMoney(money);
        order.setOaddress(oaddress);
        order.setPay(pay);
        log.info("{}", order);
        if (orderDao.queryFlower(order.getFlowerId()) == null) {
            throw new ArgumentsIllegalException("订单中花的id错误 >>" + order.getFlowerId());
        }
        if (orderDao.queryUser(order.getUserId()) == null) {
            throw new ArgumentsIllegalException("订单中用户id错误 >>" + order.getUserId());
        }
        if (orderDao.insertOne(order) == 1) {
            log.info("新增一个订单'{}'", order);
        } else {
            return -1;
        }
        return order.getId();
    }

    @Override
    public List<Order> showOrder(String message) throws NoResultsException {
        if (message == null || message.isEmpty()) {
            log.info("展示所有订单");
            return orderDao.selectAll();
        } else {
            if (orderDao.select(message) == null || orderDao.select(message).isEmpty()) {
                log.error("无信息为'{}'的订单", message);
                throw new NoResultsException("查询无结果");
            }
            log.info("展示信息为'{}'的订单", message);
            return orderDao.select(message);
        }
    }

    @Override
    public int deleteOrder(int id) throws ArgumentsIllegalException {
        if (orderDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无id为" + id + "的订单");
        }
        log.info("删除id为{}的订单", id);
        return orderDao.deleteOne(id);
    }

    @Override
    public int payOrder(int id) throws ArgumentsIllegalException {
        if (orderDao.selectById(id) == null) {
            throw new ArgumentsIllegalException("无id为" + id + "的订单");
        }
        Order order = orderDao.selectById(id);
        log.info("买了id为的'{}'这朵花", order.getFlowerId());
        Flower flower = orderDao.queryFlower(order.getFlowerId());//查花的信息
        flowerDao.reduceInventory(flower.getId());//库存减，销量加
        log.info("id为{}的订单支付成功", id);
        return orderDao.updatePay(id);
    }

    @Override
    public List<OrderDetail> selectOrder(Integer userId) throws ArgumentsIllegalException, NoResultsException {
        if (userDao.selectById(userId) == null) {
            throw new ArgumentsIllegalException("无用户id为 >>" + userId + " 的用户");
        }
        log.info("查询用户id为'{}'的订单", userId);
        List<Order> orderList = orderDao.selectByUserId(userId);
        if (orderList == null || orderList.isEmpty()) {
            throw new NoResultsException("用户id为 >>+" + userId + "的用户无订单");
        }
        List<OrderDetail> res = new ArrayList<>();
        for (int i = 0; i < orderList.size(); i++) {
            Order order = orderList.get(i);
            OrderDetail orderDetail = new OrderDetail();
            Flower flower = orderDao.queryFlower(order.getFlowerId());
            log.info(String.valueOf(flower));

            orderDetail.setId(order.getId());
            orderDetail.setFlowerId(flower.getId());
            orderDetail.setFname(flower.getFname());
            orderDetail.setImg(flower.getImg());
            orderDetail.setPrice(flower.getPrice());
            orderDetail.setPay(order.getPay());
            orderDetail.setAddress(order.getOaddress());
            res.add(orderDetail);
        }
        return res;
    }
}
