package com.su.beloving.manage.service;

import com.su.beloving.login.entity.User;

import java.util.List;

public interface ManageService {

    /**
     * 修改商品信息
     * @param jsonObj
     * @return
     */
    int updateFlower(String jsonObj);

    /**
     * 新增商品
     * @param jsonObj
     * @return
     */
    int insertFlower(String jsonObj);

    /**
     * 删除商品
     * @param id
     * @return
     */
    int deleteFlower(Integer id);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Integer id);

    /**
     * 展示用户信息
     * @param message
     * @return
     */
    List<User> showUser(String message);
}
