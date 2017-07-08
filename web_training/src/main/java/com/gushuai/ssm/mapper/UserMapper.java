package com.gushuai.ssm.mapper;

import com.gushuai.ssm.pojo.User;

import java.util.List;

/**
 * Created by asus on 2017/6/26.
 */
public interface UserMapper {

    //查询所有用户
    User findUserById(int id) throws Exception;

    //根据用户名查找密码  --- 验证登录
    String queryPwdByUsername(String username) throws Exception;

    //查找用户名
    List<String> queryUsername() throws Exception;

    //根据用户名查找用户角色
    int queryRole(String username) throws Exception;

    //插入用户到数据库
    void insertUser(User user) throws Exception;

    List<User> queryAll() throws Exception;

    //根据id删除用户
    void deleteItem(int id) throws Exception;

    //更新用户名和密码
    void updateUsdAndPwd(User user) throws Exception;

    //根据id查询用户名
    String queryUsernameById(int id) throws Exception;

    //根据id查询密码
    String queryPwdById(int id) throws Exception;

    //更新用户所有信息
    void updateUserInfo(User user) throws Exception;

    //根据用户名查询id
    int queryIdByUsername(String username) throws Exception;

    //根据id查询地址
    String queryAddress(int id) throws Exception;

    //根据id查询电话
    int queryNumber(int id) throws Exception;



}
