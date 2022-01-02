package com.su.beloving.dao;

import com.su.beloving.po.Flower;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


public interface FlowerDao {
    /**
     * 模糊查询
     *
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
    Flower selectById(int id);

    /**
     * 新增一个
     *
     * @param flower
     * @return
     */
    int insertOne(Flower flower);

    /**
     * 修改商品信息
     *
     * @param flower
     * @return
     */
    int updateOne(Flower flower);

    /**
     * 通过id逻辑删除
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 花的库存减一,销量加一
     */
    int reduceInventory(int id);

}
