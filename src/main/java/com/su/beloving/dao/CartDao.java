package com.su.beloving.dao;

import com.su.beloving.po.Cart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface CartDao {
    /**
     * 购物车中新增
     *
     * @param userId
     * @param flowerId
     * @return
     */
    int insertOne(Cart cart);

    /**
     * 用户查询自己购物车
     *
     * @param userId
     * @return
     */
    List<Cart> selectFlower(int userId);

    /**
     * 删除一个
     *
     * @param id
     * @return
     */
    int deleteOne(int id);

    /**
     * 通过id查询购物车
     *
     * @param id
     * @return
     */
    Cart selectById(int id);

}
