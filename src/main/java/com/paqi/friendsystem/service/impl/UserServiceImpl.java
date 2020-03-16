package com.paqi.friendsystem.service.impl;

import com.paqi.friendsystem.entity.user.Account;
import com.paqi.friendsystem.mapper.AccountMapper;
import com.paqi.friendsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author PQ
 * @Description 用户接口实现类
 * @Date 下午3:38 16/3/2020
 * @version 2.1.0
**/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * @author PQ
     * @Description 登录服务
     * @Date 下午3:39 16/3/2020
     * @version 2.0.0
    **/
    @Override
    public int login(Account account) {
        return accountMapper.getUserIdByAccountAndPassword(account);
    }
}