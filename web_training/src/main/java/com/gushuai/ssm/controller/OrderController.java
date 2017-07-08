package com.gushuai.ssm.controller;

import com.gushuai.ssm.exception.CustomException;
import com.gushuai.ssm.pojo.*;
import com.gushuai.ssm.service.OrderService;
import com.gushuai.ssm.service.ProductService;
import com.gushuai.ssm.service.UserService;
import com.gushuai.ssm.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.util.*;
import java.util.List;


/**
 * Created by gushuai on 2017/7/3.
 *
 */
@Controller
@SessionAttributes({"user","orderDetail"})
public class OrderController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * 根据商品id和 用户id查询信息  ---- 处理异常
     */
    @RequestMapping("/queryOrderInfo")
    @ResponseBody
    public void queryOrderInfo(@RequestBody String[] inputs, @ModelAttribute User user,Model model) throws Exception{
        String id_str = inputs[0];
        int product_id = new Integer(id_str);
        Product product = productService.queryProductById(product_id);
        if(product == null){
            throw new CustomException("产品不存在");
        }else {
            String productName = product.getProductName();
            float productPrice = product.getPrice();
            String username = user.getUsername();
            //添加电话信息
            int telPhone = user.getTelPhone();
            if(telPhone == 0){
                telPhone = userService.queryNumber(user.getId());
            }
            String address = user.getAddress();
            if(address == null){
                address = userService.queryAddress(user.getId());
            }

            //添加商品详情
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setTelPhone(telPhone);
            orderDetail.setAdderss(address);
            orderDetail.setBuyer(username);
            orderDetail.setCount(1);
            orderDetail.setProPrice(productPrice);
            orderDetail.setProName(productName);
            model.addAttribute("orderDetail", orderDetail);
        }
    }


    @RequestMapping("/confirm")
    public ModelAndView confirm(@ModelAttribute OrderDetail orderDetail){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("orderDetail",orderDetail);
        modelAndView.setViewName("/confirm");
        return modelAndView;
    }


    @RequestMapping("/login")
    public String login(){
        return "login";
    }


    /**
     * 提交订单，购买成功
     */
    @RequestMapping("/submitOrderInfo")
    @ResponseBody
    public String submitOrderInfo(@RequestBody String[] inputs) throws Exception{

        String productName = inputs[0]; //商品名
        String productPrice = inputs[1];//单价
        String buyer = inputs[2];//买家
        String phoneNumber = inputs[3];//买家电话
        String address = inputs[4];//买家地址
        String number = inputs[5];//购买数量

        //为了插入订单表得出如下信息
        int productId = 0;//商品id
        productId = orderService.queryIdByProName(productName);
        int userId = 0;//用户id
        userId = userService.queryIdByUsername(buyer);
        String orderTime = Utils.convertDate(new Date());//订单时间
        int buyCount = new Integer(number); //购买商品数量
        float price = new Float(productPrice);
        float orderPrice = buyCount * price;//订单价格
        String state = "买家已提交";
        int telPhone = new Integer(phoneNumber);//买家电话
        //直接购买的标记
        Order order = Utils.getOrder(userId,productId,orderTime,orderPrice,address,telPhone,state,buyCount,productName,buyer,0);
        try {
            orderService.insertOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/productList";

    }


    /**
     * 用户进入我的订单
     */
    @RequestMapping("/myOrders")
    public ModelAndView myOrders(@ModelAttribute User user){
        int userId = user.getId();
        List<Order> myOrders = null;
        try {
            myOrders = orderService.queryOrderById(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myOrders",myOrders);
        modelAndView.setViewName("/myorder");
        return modelAndView;
    }


    /**
     * 销售商进入订单
     */
    @RequestMapping("/showAllOrders")
    public ModelAndView showAllOrders(){
        List<Order> allOrders = null;
        try {
            allOrders = orderService.queryAllOrders();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allOrders",allOrders);
        modelAndView.setViewName("/allOrders");
        return modelAndView;
    }


    /**
     * 确定订单
     */
    @RequestMapping("/confirmOrder")
    @ResponseBody
    public String confirmOrder(@RequestBody String[] inputs){
        String order_id = inputs[0];
        int id = new Integer(order_id);
        try {
            orderService.updateState(id,"订单已确认，准备发货");
            //减少库存
            int label = orderService.queryLabelById(id);
            if(label == 0){
                //直接购买
                int productId = orderService.queryProIdByOrderId(id);
                //购买数量
                int count = orderService.queryCountsByOrderId(id);
                //根据商品id查询库存
                int proCounts = productService.queryCountsByProId(productId);
                productService.updateCounts(proCounts-count,productId);

            }else if(label == 1){
                //加入购物车结算
                //根据订单id查询userid
                int userId = orderService.queryUserIdByOrderId(id);
                //根据useid查询购物车
                List<Cart> carts = orderService.queryCartsByUserId(userId);
                //根据商品名更新库存
                for(int i = 0; i < carts.size(); i++){
                    Cart cart = carts.get(i);
                    //根据商品名查询id
                    int proId = orderService.queryIdByProName(cart.getProName());
                    int proCount = productService.queryCountsByProId(proId);
                    productService.updateCounts(proCount - cart.getProCount(),proId);
                }



            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/allOrders";
    }

    /**
     * 拒绝订单
     */
    @RequestMapping("/refuseOrder")
    @ResponseBody
    public String refuseOrder(@RequestBody String[] inputs){
        String order_id = inputs[0];
        int id = new Integer(order_id);
        try {
            orderService.updateState(id,"订单已回绝");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/allOrders";
    }


    /**
     * 加入购物车
     */
    @RequestMapping("/addCart")
    @ResponseBody
    public void addCart(@RequestBody String[] inputs, @ModelAttribute User user){
        String pro_id = inputs[0];
        int id = new Integer(pro_id);
        //根据id查询商品
        Product product = null;
        try {
            product = productService.queryProductById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Cart cart = new Cart();
        cart.setProName(product.getProductName());
        cart.setProPrice(product.getPrice());
        cart.setProCount(1);
        cart.setUserId(user.getId());
        //将信息插入数据库
        try {
            orderService.insertCart(cart);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 查看购物车 --- 根据用户id查询
     */
    @RequestMapping("/queryCarts")
    public ModelAndView queryCarts(@ModelAttribute User user){
        List<Cart> allCarts = new ArrayList<Cart>();
        try {
            allCarts = orderService.queryCartsByUserId(user.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allCarts",allCarts);
        modelAndView.setViewName("/cart");
        return modelAndView;
    }


    /**
     * 删除购物车中的商品
     */
     @RequestMapping("/deleteCartItem")
     @ResponseBody
     public void deleteCartItem(@RequestBody String idStr){
         int id = new Integer(idStr);
         try {
             orderService.deleteCartItemById(id);
         } catch (Exception e) {
             e.printStackTrace();
         }

     }


    /**
     * 结算购物车
     */
    @RequestMapping("/submitOrder")
    @ResponseBody
    public void submitOrder(@RequestBody String[] inputs,@ModelAttribute User user){
        int[] cartIdArr = new int[inputs.length];
        List<Cart> cartList = new ArrayList<Cart>();
        for(int i = 0; i < cartIdArr.length; i++){
            cartIdArr[i] = new Integer(inputs[i]);
        }
        //根据购物车id查找信息--- 商品名 + 单价 + 数量
        try {
            cartList = orderService.queryCartsById(cartIdArr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 需要从购物车中拿到  商品id + 商品名 + 商品价格 + 商品数量
        try {
            int order_id = orderService.getIdsFromCarts(cartList);
            String order_names = orderService.getProNames(cartList);
            float order_price = orderService.priceSum(cartList);
            int order_count = orderService.proCouts(cartList);
            //插入订单表信息
            String address = user.getAddress();
            if(address == null){
                address = userService.queryAddress(user.getId());
            }
            int telPhone = user.getTelPhone();
            if(telPhone == 0){
                telPhone = userService.queryNumber(user.getId());
            }
            //加入购物车结算的标记
            Order order = Utils.getOrder(user.getId(),order_id,Utils.convertDate(new Date()),order_price,
                    address,telPhone, "买家已提交",order_count,order_names,user.getUsername(),1);
            orderService.insertOrder(order);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //结算之后删除购物车信息
        for(int i = 0; i < cartIdArr.length; i++){
            try {
                orderService.deleteCartItemById(cartIdArr[i]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }




}
