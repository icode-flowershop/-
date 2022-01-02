package com.su.beloving.service;

import com.su.beloving.common.exception.ArgumentsIllegalException;
import com.su.beloving.common.exception.NoResultsException;
import com.su.beloving.dto.CartDetail;
import com.su.beloving.po.User;

import java.util.List;

public interface UserService {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param role     角色
     * @return 是否成功
     */
    Integer login(String username, String password, int role) throws ArgumentsIllegalException;

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @param phone    手机号
     * @param role     角色
     * @return 是否成功
     */
    Integer register(String username, String password, String phone, int role)throws ArgumentsIllegalException;

    /**
     * 修改用户名
     *
     * @param id       用户id
     * @param username 要改的用户名
     * @return
     */
    boolean updateUsername(Integer id, String username) throws ArgumentsIllegalException;

    /**
     * 修改密码
     *
     * @param id       用户id
     * @param password 要改的密码
     * @param valid    再输一遍(验证)
     * @return
     * @throws ArgumentsIllegalException
     */
    boolean updatePassword(Integer id, String password, String valid) throws ArgumentsIllegalException;

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    int deleteUser(Integer id) throws ArgumentsIllegalException;

    /**
     * 展示用户信息
     *
     * @param message
     * @return
     */
    List<User> showUser(String message) throws NoResultsException;

    /**
     * 用户修改自己的收货地址
     *
     * @param id      用户id
     * @param address 修改的地址
     * @return
     */
    int updateAddress(int constant, int id, String address) throws ArgumentsIllegalException;

    /**
     * 用户查看自己信息
     *
     * @param username
     * @return
     */
    User userDetail(Integer id) throws ArgumentsIllegalException;

    /**
     * 查询购物车中商品
     */
    List<CartDetail> selectCart(int userId) throws ArgumentsIllegalException, NoResultsException;

    /**
     * 购物车中新加商品
     *
     * @param userId
     * @param FlowerId
     * @return
     */
    int insertCart(int userId, int FlowerId) throws ArgumentsIllegalException;

    /**
     * 购物车中删除商品
     *
     * @param id
     * @return
     */
    int deleteCart(int id) throws ArgumentsIllegalException;


}
