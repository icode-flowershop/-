package com.su.beloving.dao;

import com.su.beloving.po.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface UserDao {

    int insertOne(User user);

    int updateById(User user);

    User selectup(String username, String password);

    User selectByUsername(String username);

    int deleteById(int id);

    List<User> selectAll();

    List<User> select(String message);

    User selectById(int id);

    int updateAddress1(int id, String address);

    int updateAddress2(int id, String address);

    int updateAddress3(int id, String address);

    int updateUsername(int id, String username);

    int updatePassword(int id, String password);


}