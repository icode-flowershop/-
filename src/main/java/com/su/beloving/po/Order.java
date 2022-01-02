package com.su.beloving.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    /**
     * 主键id
     */
    private int id;
    /**
     * 购买用户的id
     */
    private Integer userId;
    /**
     * 购买花的id
     */
    private Integer flowerId;
    /**
     * 价钱
     */
    private int money;
    /**
     * 订单地址
     */
    private String oaddress;
    /**
     * 是否支付
     */
    private int pay;
    /**
     * 逻辑删除
     */
    private int deleted;

}
