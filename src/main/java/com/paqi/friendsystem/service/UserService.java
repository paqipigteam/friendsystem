package com.paqi.friendsystem.service;

import com.paqi.friendsystem.entity.user.Account;
import com.paqi.friendsystem.entity.user.UserInfo;

import java.util.ArrayList;

/**
 * @author PQ
 * @Description
 * @Date 下午2:32 16/3/2020
 * @version 2.1.0
**/
public interface UserService {
    /**
     * @deprecated 3.4.11废弃
     * @author PQ
     * @Description
     * @param account：用户账户
     * @return 返回用户id，若为0则账户或密码不对
     * @Date 下午2:45 16/3/2020
     * @version 2.1.0
    **/
    int login(Account account);

    /**
     * 账户注册
     * @author PQ
     * @Description 账号注册
     * @param account：用户账户信息
     * @param userInfo：用户基本信息
     * @return 返回用户id
     * @Date 下午3:50 16/3/2020
     * @version 2.1.1
    **/
    int registerAccount(Account account, UserInfo userInfo);

    /**
     * 在调用registerAccount()方法前应先调用此方法检查该账户是否有被注册过
     * @author PQ
     * @Description 检查是否已有该账户
     * @param account：要注册的账号
     * @return 该账户被注册返回true，否则返回false
     * @Date 下午4:18 16/3/2020
     * @version 2.1.1
    **/
    boolean checkAccountRepeat(String account);

    /**
     * 修改用户密码
     * @author PQ
     * @Description 改密码
     * @param account：用户账户
     * @param oldPassword：用户旧密码
     * @param newPassword：用户新密码
     * @return 返回是否修改成功
     * @Date 上午12:47 18/3/2020
     * @version 3.3.2
    **/
    boolean changePassword(String account, String oldPassword, String newPassword);

    /**
     * @author PQ
     * @Description 登录
     * @param account:登录
     * @version 返回用户账户类
     * @Date 21:39 19/3/2020
     * @version 3.4.11
    **/
    Account loginAccount(Account account);

    /**
     * 根据用户账户类型查询用户列表
     * @author PQ
     * @Description 根据用户账户类型查询用户列表
     * @param userType：用户账户类型
     * @return 返回用户类型
     * @Date 14:16 20/3/2020
     * @version 3.4.13
    **/
    ArrayList<Account> getUsers(int userType);

    /**
     * 修改用户状态
     * @author PQ
     * @Description 修改用户权限
     * @param userId：用户id
     * @param status：用户状态
     * @return 若修改成功返回true，否则返回false；
     * @Date 16:12 20/3/2020
     * @version 3.4.13
    **/
    boolean setUserStatus(int userId, int status);
}
