package com.paqi.friendsystem.mapper;

import com.paqi.friendsystem.entity.user.Account;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;

/**
 * @author PQ
 * @Description 用户账号表数据库操作
 * @Date 上午2:19 16/3/2020
 * @version 2.0
**/
@Mapper
public interface AccountMapper {
    /**
     *  向数据库`account`表插入一条新的记录
     * @author PQ
     * @Description 向account表插入一条新记录
     * @param account:账号实体类，仅填写account和password
     * @return userId
     * @Date 上午2:22 16/3/2020
     * @version 2.0
    **/
    @Insert("INSERT INTO `account`(`account`, `password`, `status`, `user_type`) VALUES(#{account}, #{password}, #{status}, #{userType})")
    @Options(useGeneratedKeys = true, keyProperty = "userId", keyColumn = "user_id")
    int postAccount(Account account);

    /**
     * 根据用户的账号和密码获取用户的userId，仅当两个条件同时满足才会返回userId
     * @deprecated  3.4.11废弃,现在应该调用getAccountEntityByAccountAndPassword()来获得返回值满足需求
     * @author PQ
     * @Description 根据账户获取
     * @param account:保存的用户账户密码的实体类
     * @return 返回该用户的userId号
     * @Date 上午11:19 16/3/2020
     * @version 2.0.1
    **/
    @Select("SELECT `user_id` FROM `account` WHERE `account` = #{account} AND `password` = #{password}")
    Integer getUserIdByAccountAndPassword(Account account);

    /**
     * 根据用户账户返回用户id
     * @author PQ
     * @Description
     * @param account：用户账户
     * @return 用户id
     * @Date 下午4:23 16/3/2020
     * @version 2.1.2
    **/
    @Select("SELECT `user_id` FROM `account` WHERE `account` = #{account}")
    Integer getUserIdByAccount(String account);

    /**
     * 根据账户和旧密码更新密码
     * @author PQ
     * @Description 更改密码
     * @param account：用户账户
     * @param oldPassword：旧密码
     * @param newPassword：新密码
     * @return 返回受影响的行数
     * @Date 上午12:39 18/3/2020
     * @version 3.3.1
    **/
    @Update("UPDATE `account` SET `password` = #{newPassword} " +
            "WHERE `account` = #{account} AND `password` = #{oldPassword}")
    int putPasswordByAccountAndOldPassword(@Param("account") String account, @Param("oldPassword") String oldPassword,
                                           @Param("newPassword")String newPassword);

    /**
     * 根据账户和密码返回整个类
     * @author PQ
     * @Description 登录
     * @param account:账户
     * @param password:密码
     * @return 返回用户账户类
     * @Date 21:26 19/3/2020
     * @version 3.4.11
    **/
    @Select("SELECT * FROM `account` " +
            "WHERE `account` = #{account} AND `password` = #{password}")
    @Results(value={
            @Result(column="user_id", property="userId", id=true),
            @Result(column="account", property="account"),
            @Result(column="password ", property="password"),
            @Result(column="user_type", property="userType")
    })
    Account getAccountEntityByAccountAndPassword(@Param("account") String account, @Param("password") String password);

    /**
     * 根据用户类型获取用户列表
     * @author PQ
     * @Description 根据用户类型获取用户列表
     * @param userType：用户类型
     * @return 返回用户列表
     * @Date 14:12 20/3/2020
     * @version 3.4.13
    **/
    @Select("SELECT * FROM `account` " +
            "WHERE `user_type` = #{userType}")
    ArrayList<Account> getAllUser(int userType);

    /**
     * 更改账户状态
     * @author PQ
     * @Description 设置用户账户状态
     * @param userId：用户id
     * @param status：用户状态 1可用，0禁用
     * @return 返回受影响的行数
     * @Date 15:59 20/3/2020
     * @version 3.4.14
    **/
    @Update("UPDATE `account` SET `status` = #{status} WHERE `user_id` = #{userId} ")
    Integer putAccountStatus(int userId, int status);
}
