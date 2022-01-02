package com.su.beloving.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail {

    /**
     * 订单主键id
     */
    private Integer id;

    /**
     * 花的id
     */
    private Integer flowerId;

    /**
     * 订单中的花名
     */
    private String fname;

    /**
     *订单中花的图片
     */
    private String img;

    /**
     * 花的价格
     */
    private Integer price;

    /**
     * 是否支付
     */
    private int pay;

    /**
     * 订单地址
     */
    private String address;


}
