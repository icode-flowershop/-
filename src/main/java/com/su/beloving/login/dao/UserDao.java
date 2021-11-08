package com.su.beloving.login.dao;

import com.su.beloving.login.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int selectup(String username,String password);

    int selectUsername(String username);
}