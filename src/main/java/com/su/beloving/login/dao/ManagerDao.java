package com.su.beloving.login.dao;

import com.su.beloving.login.entity.Manager;

public interface ManagerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    Manager selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);
    int selectup(String username,String password);

    int selectUsername(String username);
}