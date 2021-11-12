package com.su.beloving.home.dao;

import com.su.beloving.home.entity.Flower;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FlowerDao {
    /**
     * 模糊查询
     * @return
     */
    List<Flower> select(String message);

    /**
     * 查询所有
     */
    List<Flower> selectAll();

    /**
     * 通过id查询
     */
    Flower selectOne(int id);

    /**
     * 新增一个
     * @param flower
     * @return
     */
    int insertOne(Flower flower);

    /**
     * 修改商品信息
     * @param flower
     * @return
     */
    int updateOne(Flower flower);


    /**
     * 通过id逻辑删除
     * @param id
     * @return
     */
    int deleteById(int id);

}
