package com.su.beloving.dto;

import com.su.beloving.po.Flower;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartDetail {
    /**
     * 购物车的主键id
     */
    private Integer id;
    /**
     * 购物车中的花
     */
    private Flower flower;

}
