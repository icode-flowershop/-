package com.su.beloving.home.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flower {
    /**
     * 主键id
     */
    private int id;
    /**
     * 图片
     */
    private String img;
    /**
     * 花名
     */
    private String fname;
    /**
     * 价格
     */
    private int price;
    /**
     * 已售数量
     */
    private int sold;
    /**
     * 花语
     */
    private String says;
    /**
     * 材料
     */
    private String material;
    /**
     * 包装
     */
    private String packaging;
    /**
     * 库存
     */
    private int inventory;
    /**
     * 逻辑删除
     */
    private int deleted;


    public boolean valid() {
        return false;
    }
}
