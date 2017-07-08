package com.gushuai.ssm.controller;

import com.gushuai.ssm.exception.CustomException;
import com.gushuai.ssm.pojo.Product;
import com.gushuai.ssm.pojo.User;
import com.gushuai.ssm.service.ProductService;
import com.gushuai.ssm.service.UserService;
import com.gushuai.ssm.util.Utils;
import com.sun.javafx.sg.prism.NGShape;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.rmi.CORBA.Util;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.UnknownServiceException;
import java.util.List;

/**
 * Created by gushuai on 2017/6/27.
 * 登录管理界面
 */
@Controller
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ProductService productService;

    /**
     *登录验证
     */
    @RequestMapping(value = "/loginValidate",method = RequestMethod.POST)
    public String loginValidate(@Valid User user, BindingResult errors, Model model) throws Exception{

        String username = user.getUsername();
        String password = user.getPassword();
        //判断用户名是否存在
        List<String> nameList = userService.queryUsername();
        if(nameList == null || nameList.size() == 0){
            throw new CustomException("没有任何用户存在");
        }
        boolean contain = nameList.contains(username);
        String userMsgHint = "";
        String pwdMsgHint = "";
        String skipPage = "";
        //用户名存在
        if(contain){
            String pwd = Utils.stringMd5(password);
            String realPwd = null;
            try {
                realPwd = userService.queryPwdByUser(username);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //密码验证正确
            if(pwd.equals(realPwd)){
                //设置用户信息
                int id = 0;
                try {
                    id = userService.queryIdByUsername(username);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                user.setId(id);
                String address = null;
                try {
                    address = userService.queryAddress(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(address != null){
                    user.setAddress(address);
                }
                int telPhone = 0;
                try {
                    telPhone = userService.queryNumber(id);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if(telPhone != 0){
                    user.setTelPhone(telPhone);
                }

                model.addAttribute("user",user);
                //根据用户角色跳转不同的页面
                int type = 0;
                try {
                    type = userService.queryRole(username);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                switch (type){
                    //管理员
                    case 1 :
                        skipPage = "adminManager";
                        List<User> userList = null;
                        try {
                            userList = userService.queryAll();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        model.addAttribute("userList",userList);
                        break;
                    //销售商
                    case 2:
                        skipPage = "operateAdd";
                        break;
                    //普通用户
                    case 3:
                        List<Product> allProducts = null;
                        try {
                            allProducts = productService.queryAllProducts();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        model.addAttribute("allProducts",allProducts);
                        skipPage = "productList";
                        break;
                }
            }else{
                //提示密码不正确
                pwdMsgHint = "密码不正确";
                model.addAttribute("pwdMsgHint",pwdMsgHint);
                //map.put("pwdMsgHint",pwdMsgHint);
            }
        }else{
            //提示用户名不正确
            userMsgHint = "用户名不存在";
            model.addAttribute("userMsgHint",userMsgHint);
        }

        return skipPage;

    }


    /**
     * 登出
     */
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session,Model model){
        User user = new User();
        model.addAttribute("user",user);
        session.invalidate();
        return "forward:login";
    }



    //管理员界面
    @RequestMapping("/addUser")
    @ResponseBody
    public ModelAndView adminManager(@RequestBody String[] inputs,ModelMap modelMap){
        String hintMessage = "";
        ModelAndView modelAndView = new ModelAndView();
        String username = inputs[0];
        String pwd_1 = inputs[1];
        String pwd_2 = inputs[2];
        User addUser = new User();

        if(username.equals("") || pwd_1.equals("")){
            modelAndView.addObject("addUser",addUser);
            modelAndView.setViewName("/adminManager");
            return modelAndView;
        }

        if(pwd_1.equals(pwd_2)){
            addUser.setUsername(username);
            String pwdMd5 = Utils.stringMd5(pwd_1);
            addUser.setPassword(pwdMd5);
            try {
                userService.insertUser(addUser);
            } catch (Exception e) {
                e.printStackTrace();
            }
            modelAndView.addObject("addUser",addUser);
            modelAndView.setViewName("/adminManager");
        }else{
            hintMessage = "密码不一致,请重新确认";
            modelMap.put("hintMessage",hintMessage);
            modelAndView.setViewName("/adminManager");
        }
        return modelAndView;
    }


    //删除用户
    @RequestMapping("/deleteItem")
    @ResponseBody
    public String deleteItem(@RequestBody int inputs,Model model){
        try {
            userService.deleteItem(inputs);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<User> userList = null;
        try {
            userList = userService.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userList",userList);
        return "delete success";
    }


    //更新用户名和密码
    @RequestMapping("/updateItem")
    @ResponseBody
    public String updateItem(@RequestBody String[] input_users,Model model){

        String username = input_users[0];
        String password = input_users[1];
        int id = new Integer(input_users[2]);
        User user = new User();
        if(password.equals("")){
            try {
                password = userService.queryPwdById(id);
            } catch (Exception e) {
                e.printStackTrace();
            }
            user.setPassword(password);
        }else{
            user.setPassword(Utils.stringMd5(password));
        }
        user.setUsername(username);
        user.setId(id);
        try {
            userService.updateUseAndPwd(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //更新视图
        List<User> userList = null;
        try {
            userList = userService.queryAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("userList",userList);
        return "/adminManager";
    }


    //更改普通用户个人信息
    @RequestMapping("/changeUserInfo")
    public ModelAndView changeUserInfo(@ModelAttribute User user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user",user);
        modelAndView.setViewName("/userInfo");
        return modelAndView;
    }



    //提交修改信息到数据库
    @RequestMapping("/submitUserInfo")
    @ResponseBody
    public String submitUserInfo(@RequestBody String [] inputs){
        String username = inputs[0];
        String password = inputs[1];
        String address = inputs[2];
        String telPhone = inputs[3];
        String userId = inputs[4];
        int id = new Integer(userId);
        String pwd = Utils.stringMd5(password);
        int telNumber = new Integer(telPhone);
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(pwd);
        user.setAddress(address);
        user.setTelPhone(telNumber);
        try {
            userService.updateUserInfo(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/productList";
    }



}
