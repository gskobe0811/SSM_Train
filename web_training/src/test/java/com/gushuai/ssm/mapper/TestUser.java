package com.gushuai.ssm.mapper;

import com.gushuai.ssm.mapper.UserMapper;
import com.gushuai.ssm.pojo.User;
import com.gushuai.ssm.util.Utils;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Scanner;


/**
 * Created by asus on 2017/6/26.
 */
public class TestUser {

     private ApplicationContext applicationContext;
     private UserMapper userMapper;

     @Before
     public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring_dao.xml");
        userMapper = (UserMapper) applicationContext.getBean("userMapper");
     }

     @Test
    public void testFindUserById() throws Exception{

//         String password = userMapper.queryPwdByUsername("admin");
//         System.out.println(password);
//
//         int type = userMapper.queryRole("admin");
//         System.out.println(type);
//
//
//         List<String> list = userMapper.queryUsername();
//         System.out.println(list);

//         User user = (User) userMapper.findUserById(1);
//        // System.out.println(user);
         //String str = stringMd5("hello");
//         String str = Utils.stringMd5("hello");
//         System.out.println(str);

         String str_1 = Utils.stringMd5("world");
         System.out.println(str_1);


     }


     @Test
    public void testQuestion(){

     }





}
