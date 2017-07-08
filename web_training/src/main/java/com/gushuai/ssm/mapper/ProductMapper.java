package com.gushuai.ssm.mapper;

import com.gushuai.ssm.pojo.Product;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by asus on 2017/6/27.
 * 首页展示Mapper
 */
public interface ProductMapper {

    List<Product> queryAllProducts() throws Exception;

    //添加商品 -- 销售商
    void addProduct(Product product) throws Exception;

    //根据id查询产品
    Product queryProductById(int id) throws Exception;

    //根据id更新修改后商品信息
    void updateProduct(Product product) throws Exception;

    //根据id删除商品信息
    void deleteProduct(int id) throws Exception;

    //根据商品名查询id
    int queryIdByProName(String proName) throws Exception;



    //根据商品id查询库存
    int  queryCountsByProId(int id) throws Exception;


    //更新商品库存
    void updateProCounts(int counts, int id) throws Exception;


}
