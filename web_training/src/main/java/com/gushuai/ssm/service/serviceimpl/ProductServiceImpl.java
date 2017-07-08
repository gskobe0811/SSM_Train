package com.gushuai.ssm.service.serviceimpl;

import com.gushuai.ssm.mapper.ProductMapper;
import com.gushuai.ssm.mapper.UserMapper;
import com.gushuai.ssm.pojo.Product;
import com.gushuai.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by asus on 2017/6/27.
 */
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductMapper productMapper;


    public List<Product> queryAllProducts() throws Exception{
        return productMapper.queryAllProducts();
    }

    @Transactional(rollbackFor = Exception.class)
    public void addProduct(Product product) throws Exception {
        productMapper.addProduct(product);
    }


    public Product queryProductById(int id) throws Exception {
        return productMapper.queryProductById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateProduct(Product product) throws Exception {
        productMapper.updateProduct(product);
    }

    @Transactional(rollbackFor = Exception.class)
    public void deleteProduct(int id) throws Exception {
        productMapper.deleteProduct(id);
    }


    public int queryCountsByProId(int id) throws Exception {
        return productMapper.queryCountsByProId(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void updateCounts(int count, int id) throws Exception {
        productMapper.updateProCounts(count,id);
    }


    public int queryProIdByProName(String proName) throws Exception {
        return productMapper.queryIdByProName(proName);
    }



}
