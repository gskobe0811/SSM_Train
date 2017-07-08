package com.gushuai.ssm.service;

import com.gushuai.ssm.pojo.Cart;
import com.gushuai.ssm.pojo.Order;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/7/3.
 */
public interface OrderService {

    //根据商品名查询id

    int queryIdByProName(String proName) throws Exception;

    //插入订单信息
    @Transactional(rollbackFor = Exception.class)
    void insertOrder(Order order) throws Exception;

    //查询所有订单

    List<Order> queryAllOrders() throws Exception;

    //根据用户查询订单

    List<Order> queryOrderById(int userId) throws Exception;

    //根据id查询状态

    String queryStateById(int id) throws Exception;

    //根据id更新状态
    @Transactional(rollbackFor = Exception.class)
    void updateState(int id,String state) throws Exception;

    //插入购物车信息
    @Transactional(rollbackFor = Exception.class)
    void insertCart(Cart cart) throws Exception;

    //查询购物车信息
    List<Cart> queryCarts() throws Exception;

    //根据id删除购物车内容
    @Transactional(rollbackFor = Exception.class)
    void deleteCartItemById(int id) throws Exception;

    //根据id查找购物车信息
    List<Cart> queryCartsById(int[] id) throws Exception;

    //拿到购物车中商品id 如果有多个商品则把连接起来
    int getIdsFromCarts(List<Cart> carts) throws Exception;

    //取出购物车中商品名字。不同商品名用，分隔
    String getProNames(List<Cart> carts);

    //计算购物车中的商品价格总和
    float priceSum(List<Cart> carts)throws Exception;

    //计算购物车中的商品数量
    int proCouts(List<Cart> carts) throws Exception;


    //根据用户id查询购物车

    List<Cart> queryCartsByUserId(int userId) throws Exception;

    //根据订单id查询标记
    int queryLabelById(int orderId) throws Exception;

    //根据订单id查询商品id
    int queryProIdByOrderId(int orderId) throws Exception;

    //根据订单id查询购买数量
    int queryCountsByOrderId(int orderId) throws Exception;

    //根据订单id查询userid
    int queryUserIdByOrderId(int orderId) throws Exception;


    //根据userid查询购物车
   // List<Cart> queryCartsByUserId(int userId) throws Exception;

}
