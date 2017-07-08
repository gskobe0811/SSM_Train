package com.gushuai.ssm.service;

import com.gushuai.ssm.pojo.Product;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/27.
 */
public interface ProductService {

    /**
     * 查询所有商品，将其显示到主页上
     */
    List<Product> queryAllProducts() throws Exception;

    /**
     * 销售商添加商品
     */
    @Transactional(rollbackFor = Exception.class)
    void addProduct(Product product) throws Exception;

    /**
     * 根据id查询商品
     */
    Product queryProductById(int id) throws Exception;

    /**
     * 更新商品信息
     */
    @Transactional(rollbackFor = Exception.class)
    void updateProduct(Product product) throws Exception;

    /**
     * 删除商品
     */
    @Transactional(rollbackFor = Exception.class)
    void deleteProduct(int id) throws Exception;

    /**
     * 根据商品id查询库存
     */
    int queryCountsByProId(int id) throws Exception;

    /**
     * 根据商品id更新库存
     */
    @Transactional(rollbackFor = Exception.class)
    void updateCounts(int count, int id) throws Exception;


    /**
     * 根据商品名查询id
     */
    int queryProIdByProName(String proName) throws Exception;



}
