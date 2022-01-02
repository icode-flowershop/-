package com.su.beloving.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * manager
 *
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

    private Integer deleted;

    private static final long serialVersionUID = 1L;
}