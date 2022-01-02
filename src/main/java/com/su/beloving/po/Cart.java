package com.su.beloving.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    /**
     * 主键id
     */
    private int id;
    /**
     * 用户id
     */
    private int userId;
    /**
     * 商品id
     */
    private int flowerId;
    /**
     * 逻辑删除
     */
    private int deleted;
}
