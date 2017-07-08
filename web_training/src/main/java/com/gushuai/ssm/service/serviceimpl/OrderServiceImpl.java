package com.gushuai.ssm.service.serviceimpl;

import com.gushuai.ssm.mapper.OrderMapper;
import com.gushuai.ssm.pojo.Cart;
import com.gushuai.ssm.pojo.Order;
import com.gushuai.ssm.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by asus on 2017/7/3.
 */
@Service

public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    public int queryIdByProName(String proName) throws Exception {
        return orderMapper.queryIdByProName(proName);
    }


    //数据库事物处理
    @Transactional(rollbackFor = Exception.class)
    public void insertOrder(Order order) throws Exception {
        orderMapper.insertOrder(order);
    }


    public List<Order> queryAllOrders() throws Exception {
        return orderMapper.queryAllOrders();
    }


    public List<Order> queryOrderById(int userId) throws Exception {
        return orderMapper.queryOrdersById(userId);
    }


    public String queryStateById(int id) throws Exception {
        return orderMapper.selectStateById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateState(int id, String state) throws Exception {
        orderMapper.updateOrderStateById(id,state);
    }

    @Transactional(rollbackFor = Exception.class)
    public void insertCart(Cart cart) throws Exception {
        orderMapper.insertCart(cart);
    }

    public List<Cart> queryCarts() throws Exception {
        return orderMapper.queryCarts();
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteCartItemById(int id) throws Exception {
        orderMapper.deleteCartItem(id);
    }

    /**
     * ========= 购物车相关功能============
     */



    /**
     * 根据id查找所有的购物车信息
     */
    public List<Cart> queryCartsById(int[] id) throws Exception{
        List<Cart> cartList = new ArrayList<Cart>();
        for(int i = 0; i < id.length; i++){
            Cart cart = orderMapper.queryCartById(id[i]);
            cartList.add(cart);
        }
        return cartList;
    }


    /**
     * 拿到购物车中商品id 如果有多个商品则把连接起来
     */
    public int getIdsFromCarts(List<Cart> carts) throws Exception{
        StringBuilder sb = new StringBuilder();
        String str = null;

        for(int i = 0; i < carts.size(); i++){
           int proId = orderMapper.queryIdByProName(carts.get(i).getProName());
           sb.append(String.valueOf(proId));
        }
        if(sb.length() < 10){
            str = sb.toString().substring(0,sb.length());
        }else{
            str = sb.toString().substring(0,10);
        }

        return Integer.parseInt(str);

    }


    /**
     * 取出购物车中商品名字。不同商品名用，分隔
     */
    public String getProNames(List<Cart> carts){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < carts.size(); i++){
            sb.append(carts.get(i).getProName()).append(",");
        }
        //把最后一个,去掉
        return sb.substring(0,sb.length()-1);
    }




    /**
     * 计算购物车中的商品价格总和
     */
     public float priceSum(List<Cart> carts)throws Exception{
         float priceCount = 0;
         for(int i = 0; i < carts.size(); i++){
             priceCount = priceCount + carts.get(i).getProCount() * carts.get(i).getProPrice();
         }
         return priceCount;
     }


    /**
     * 计算购物车中的商品数量
     */
    public int proCouts(List<Cart> carts) throws Exception{
        int sum = 0;
        for(int i = 0; i < carts.size(); i++){
            sum = sum + carts.get(i).getProCount();
        }
        return sum;
    }


    /**
     * 根据userId查询购物车
     * @param userId
     * @return
     * @throws Exception
     */
    public List<Cart> queryCartsByUserId(int userId) throws Exception {
        return orderMapper.queryCartsByUsername(userId);
    }

    /**
     * 根据订单id查询标记
     * @param orderId
     * @return
     * @throws Exception
     */
    public int queryLabelById(int orderId) throws Exception {
        return orderMapper.queryLableById(orderId);
    }

    /**
     * 查询商品id
     * @param orderId
     * @return
     * @throws Exception
     */
    public int queryProIdByOrderId(int orderId) throws Exception {
        return orderMapper.queryProIdByOrderId(orderId);
    }

    /**
     * 查询购买数量
     * @param orderId
     * @return
     * @throws Exception
     */
    public int queryCountsByOrderId(int orderId) throws Exception {
        return orderMapper.queryCountsByOrderId(orderId);
    }


    /**
     * 查询userid
     */
    public int queryUserIdByOrderId(int orderId) throws Exception {
        return orderMapper.queryUserIdByOrderId(orderId);
    }
}
