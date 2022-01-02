package com.su.beloving.dao;

import com.su.beloving.po.Manager;
import org.apache.ibatis.annotations.Mapper;


public interface ManagerDao {

    int insertOne(Manager manager);

    Manager selectup(String username, String password);

    Manager selectByUsername(String username);
}