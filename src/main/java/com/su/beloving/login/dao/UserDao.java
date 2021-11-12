package com.su.beloving.login.dao;

import com.su.beloving.login.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {

    int insert(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectup(String username,String password);

    User selectUsername(String username);

    int deleteById(int id);

    List<User> selectAll();

    List<User> select(String message);
}