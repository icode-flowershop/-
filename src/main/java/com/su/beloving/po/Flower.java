package com.su.beloving.po;

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
     * 类别
     */
    private String kind;

    /**
     * 逻辑删除
     */
    private int deleted;

    /**
     * 参数校验
     *
     * @return
     */
    public boolean valid() {
        boolean v1 = (this.getFname() == null || this.getFname().isEmpty());
        boolean v2 = (this.getImg() == null || this.getImg().isEmpty());
        boolean v3 = (this.getSays() == null || this.getSays().isEmpty());
        boolean v4 = (this.getMaterial() == null || this.getMaterial().isEmpty());
        boolean v5 = (this.getPackaging() == null || this.getPackaging().isEmpty());
        boolean v6 = (this.getPrice() == 0);
        boolean v7 = (this.getKind() == null || this.getKind().isEmpty());
        if (v1 || v2 || v3 || v4 || v5 || v6 || v7)
            return false;
        return true;
    }
}
