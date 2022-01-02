package com.su.beloving.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * user
 *
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 第一个地址
     */
    private String faddress;

    /**
     * 第二个地址
     */
    private String saddress;

    /**
     * 第三个地址
     */
    private String taddress;

    /**
     * 逻辑删除
     */
    private Integer deleted;

    private static final long serialVersionUID = 1L;
}