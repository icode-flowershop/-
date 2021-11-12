package com.su.beloving.login.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * manager
 * @author 
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager implements Serializable {
    private Integer id;

    private String username;

    private String password;

    private String phone;

    private String email;

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}