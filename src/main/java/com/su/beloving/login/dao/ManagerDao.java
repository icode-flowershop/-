package com.su.beloving.login.dao;

import com.su.beloving.login.entity.Manager;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ManagerDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Manager record);

    int insertSelective(Manager record);

    int updateByPrimaryKeySelective(Manager record);

    int updateByPrimaryKey(Manager record);

    Manager selectup(String username, String password);

    Manager selectUsername(String username);
}