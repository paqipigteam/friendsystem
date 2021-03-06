package com.paqi.friendsystem.entity.user;

import lombok.Data;

/**
 * @author PQ
 * @Description 用户账户实体类
 * @Date 上午1:56 16/3/2020
 * @version 1.2.0
**/
@Data
public class Account {
    private int userId;
    private String account;
    private String password;
    private int userType;
    private int status;
}
