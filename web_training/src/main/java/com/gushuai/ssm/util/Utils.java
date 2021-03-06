package com.gushuai.ssm.util;

import com.gushuai.ssm.pojo.Order;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by asus on 2017/6/27.
 */
public class Utils {


    public static String stringMd5(String input){
        try{
            //拿到一个MD5转换器（如果想要SHA1加密参数换成"SHA1"）
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            //输入的字符串转换成字节数组
            byte[] inputByteArray = input.getBytes();
            //inputByteArray是输入字符串转换得到的字节数组
            messageDigest.update(inputByteArray);
            //转换并返回结果，也是字节数组，包含16个元素
            byte[] resultByteArray = messageDigest.digest();
            //字符数组转换成字符串返回
            return byteArrayToHex(resultByteArray);
        }catch(NoSuchAlgorithmException e){
            return null;
        }
    }

    public static String byteArrayToHex(byte[] byteArray){
        //首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        //new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符）
        char[] resultCharArray = new char[byteArray.length*2];
        //遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for(byte b : byteArray){
            resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b& 0xf];
        }

        //字符数组组合成字符串返回
        return new String(resultCharArray);
    }


    //转换时间格式为string
    public static String convertDate(Date currentTime){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }


    //向订单表中插入信息
    public static Order getOrder(int userId, int productId, String orderTime, float orderPrice,
                                 String address, int telphone, String state, int productCount,String productName, String username,int labelBuy){
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityId(productId);
        order.setOrderTime(orderTime);
        order.setOrderPrice(orderPrice);
        order.setAddress(address);
        order.setTelPhone(telphone);
        order.setState(state);
        order.setProCount(productCount);
        order.setProName(productName);
        order.setUsername(username);
        order.setLabelBuy(labelBuy);
        return order;
    }



}
