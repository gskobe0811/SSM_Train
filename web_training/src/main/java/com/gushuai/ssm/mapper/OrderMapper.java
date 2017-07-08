package com.gushuai.ssm.mapper;

import com.gushuai.ssm.pojo.Cart;
import com.gushuai.ssm.pojo.Order;

import java.util.List;

/**
 * Created by asus on 2017/7/3.
 * 订单mapper
 */
public interface OrderMapper {

    //根据商品名查询商品id
    int queryIdByProName(String productName) throws Exception;

    //插入订单信息
    void insertOrder(Order order) throws Exception;

    //查询所有订单 ---- 针对销售商
    List<Order> queryAllOrders() throws Exception;


    //根据用户查询订单
    List<Order> queryOrdersById(int id) throws Exception;




    //根据id查订单状态
    String selectStateById(int id) throws Exception;

    //根据id更新订单状态
    void updateOrderStateById(int id,String state) throws Exception;

    //将购物车信息插入到购物车表中
    void  insertCart(Cart cart) throws Exception;

    //查看所有购物车信息
    List<Cart> queryCarts() throws Exception;


    //根据id删除购物车内容
    void deleteCartItem(int id) throws Exception;

    //根据id查找购物车
    Cart queryCartById(int id) throws Exception;

    //根据userId查看购物车
    List<Cart> queryCartsByUsername(int userId) throws Exception;

    //根据订单id查询订单标记
    int queryLableById(int orderId) throws Exception;


    //根据订单id查询商品id
    int queryProIdByOrderId(int id) throws Exception;

    //根据订单id查询购买数量
    int queryCountsByOrderId(int id) throws Exception;

    //根据订单id查询userid
    int queryUserIdByOrderId(int id) throws Exception;



}
