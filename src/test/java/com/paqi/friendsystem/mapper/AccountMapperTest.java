package com.paqi.friendsystem.mapper;

import com.paqi.friendsystem.entity.user.Account;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

/**
 * @author PQ
 * @Description 账号测试类
 * @Date 上午2:43 16/3/2020
 * @version 2.0
**/
@SpringBootTest
public class AccountMapperTest {
    @Autowired
    private AccountMapper accountMapper;

    /**
     * @author PQ
     * @Description 测试插入语句是否正确
     * @Date 上午2:44 16/3/2020
     * @version 2.0
    **/
    @Test
    public void testPostAccount() {
        Account account = new Account();
        account.setAccount("test3");
        account.setPassword("test");
        account.setUserType(1);
        int ret = accountMapper.postAccount(account);
        System.out.println("ret = " + ret);
//        Assertions.assertEquals( 1, ret);
    }

    /**
     * @author PQ
     * @Description 测试根据账户或密码查询是否正确
     * @Date 上午11:34 16/3/2020
     * @version 2.0.1
    **/
    @Test
    public void testGetUserIdByAccountAndPassword() {
        Account account = new Account();
        account.setAccount("test1");
        account.setPassword("test");
        account.setUserType(1);
        int userId = accountMapper.getUserIdByAccountAndPassword(account);
        Assertions.assertEquals(1, userId);
    }

    /**
     * @author PQ
     * @Description 测试根据账户返回用户id
     * @Date 下午4:25 16/3/2020
     * @version 2.1.1
    **/
    @Test
    public void testUserIdByAccount() {
        String account = "test1";
        int userId = accountMapper.getUserIdByAccount(account);
        Assertions.assertEquals(5, userId);
    }

    /**
     * @author PQ
     * @Description 修改密码
     * @Date 上午12:43 18/3/2020
     * @version 3.3.1
    **/
    @Test
    public void testPutPasswordByAccountAndPassword() {
        String account = "test1";
        String oldPassword = "test";
        String newPassword = "test1";
        int ret = accountMapper.putPasswordByAccountAndOldPassword(account, oldPassword, newPassword);
        Assertions.assertEquals(1, ret);
    }

    /**
     * @author PQ
     * @Description 测试登录
     * @Date 15:34 20/3/2020
     * @version 3.4.13
    **/
    @Test
    public void testLogin() {
        Account account = new Account();
        account.setAccount("test1");
        account.setPassword("test");
        Account dbAccount = accountMapper
                .getAccountEntityByAccountAndPassword(account.getAccount(), account.getPassword());
        System.out.println("dbAccount = " + dbAccount);
    }

    /**
     * @author PQ
     * @Description 测试获取全部用户
     * @Date 15:35 20/3/2020
     * @version 3.4.13
    **/
    @Test
    public void testgetUsers() {
        int userType = 1;
        ArrayList<Account> accounts = accountMapper.getAllUser(1);
        System.out.println("accounts-size :"+accounts.size());
        for(Account account : accounts) {
            System.out.println("account = " + account);
        }
    }
}
