package com.gushuai.ssm.service.serviceimpl;

import com.gushuai.ssm.mapper.UserMapper;
import com.gushuai.ssm.pojo.User;
import com.gushuai.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/27.
 */

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    public String queryPwdByUser(String username) throws Exception {
        return userMapper.queryPwdByUsername(username);
    }

    public List<String> queryUsername() throws Exception {
        return userMapper.queryUsername();
    }

    public int queryRole(String username) throws Exception{
        return userMapper.queryRole(username);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertUser(User user) throws Exception {
         userMapper.insertUser(user);
    }

    public List<User> queryAll() throws Exception {
        return userMapper.queryAll();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteItem(int ids) throws Exception {
        userMapper.deleteItem(ids);

    }





    //更新用户名和密码
    @Transactional(rollbackFor = Exception.class)
    public void updateUseAndPwd(User user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        //更新用户id
        int id = user.getId();
        //用户没有更新用户名，则使用原始用户名
        if(username.equals("")){
            String real_username = queryUsernameById(id);
            user.setUsername(real_username);
        }
        //用户没有更新密码
        if(password.equals("")){
            String real_pwd = queryPwdById(id);
            user.setPassword(real_pwd);
        }
        userMapper.updateUsdAndPwd(user);

    }


    public String queryUsernameById(int id) throws Exception {
        return userMapper.queryUsernameById(id);
    }

    public String queryPwdById(int id) throws Exception {
        return userMapper.queryPwdById(id);
    }

    //根据用户名查询id
    public int queryIdByUsername(String username) throws Exception {
        return userMapper.queryIdByUsername(username);
    }

    //更新用户个人信息
    @Transactional(rollbackFor = Exception.class)
    public void updateUserInfo(User user) throws Exception {
        userMapper.updateUserInfo(user);
    }


    public String queryAddress(int id) throws Exception {
        return userMapper.queryAddress(id);
    }

    public int queryNumber(int id) throws Exception {
        return userMapper.queryNumber(id);
    }


}
