package com.gushuai.ssm.service;

import com.gushuai.ssm.pojo.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutorService;

/**
 * Created by asus on 2017/6/27.
 */

public interface UserService {

    //根据用户名查询密码
    String queryPwdByUser(String username) throws Exception;

    //查找所有的用户名
    List<String> queryUsername() throws Exception;

    //根据用户名查找角色
    int queryRole(String usernmae) throws Exception;

    //插入用户
    @Transactional(rollbackFor = Exception.class)
    void insertUser(User user) throws Exception;

    //查询所有的用户
    List<User> queryAll() throws Exception;

    //删除选中用户
    @Transactional(rollbackFor = Exception.class)
    void deleteItem(int ids) throws Exception;

    //更新用户名和密码
    @Transactional(rollbackFor = Exception.class)
    void updateUseAndPwd(User user) throws Exception;

    //根据id查询用户名
    String queryUsernameById(int id) throws Exception;

    //根据id查询密码
    String queryPwdById(int id) throws Exception;

    //根据用户名查询id
    int queryIdByUsername(String username) throws Exception;

    //更新用户个人信息
    @Transactional(rollbackFor = Exception.class)
    void updateUserInfo(User user) throws Exception;

    //根据id查询地址
    String queryAddress(int id) throws Exception;

    //根据id查询电话
    int queryNumber(int id) throws Exception;



}
