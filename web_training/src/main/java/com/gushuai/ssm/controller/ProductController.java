package com.gushuai.ssm.controller;

import com.gushuai.ssm.pojo.Product;
import com.gushuai.ssm.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by gushuai on 2017/6/27.
 */

@Controller
@SessionAttributes("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/queryAllProducts")
    public ModelAndView queryAllProducts(){
        List<Product> allProducts = null;
        try {
            allProducts = productService.queryAllProducts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("allProducts",allProducts);
        modelAndView.setViewName("/productList");
        return modelAndView;
    }


    //进入登录界面
    @RequestMapping("/loginUi")
    public String loginUi(){
        return "login";
    }



    /**
     * 商品信息上传
     */
     @RequestMapping("/productUpload")
     public String productUpload(Product product, HttpServletRequest request,

                                 @RequestParam(value = "file",required = false)  MultipartFile items_pic){

         String pathRoot = request.getSession().getServletContext().getRealPath("/");
         String path = "";
         //插入图片
         if(items_pic != null){
             String uuid = UUID.randomUUID().toString().replaceAll("-","");
             String contentType = items_pic.getContentType();
             String imageName = contentType.substring(contentType.indexOf("/")+1);
             path = "/pic/"+uuid+"."+imageName;
             File newFile = new File(pathRoot + path);
             try {
                 items_pic.transferTo(newFile);
             } catch (IOException e) {
                 e.printStackTrace();
             }
             product.setPicture(path);
             try {
                 productService.addProduct(product);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }else{
             //不插入图片
             try {
                 productService.addProduct(product);
             } catch (Exception e) {
                 e.printStackTrace();
             }
         }

         return "/operateAdd";

     }



    /**
     * 销售商管理商品
     */
    @RequestMapping("/managerProduct")
    public ModelAndView managerProduct(){
        List<Product> productList = null;
        try {
            productList = productService.queryAllProducts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("/productManager");
        return modelAndView;
    }


    /**
     * post提交参数之后，查询商品
     */
    @RequestMapping("/changeProduct")
    @ResponseBody
    public void changeProduct(@RequestBody String[] inputs,Model model){
        //拿到修改商品编号
        String id_str = inputs[0];
        int id = new Integer(id_str);
        //根据编号查询信息
        Product product = null;
        try {
            product = productService.queryProductById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("product",product);
    }

    /**
     * 显示需要修改商品的信息
     * @param product
     * @return
     */
    @RequestMapping("/productModify")
    public ModelAndView productModify(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",product);
        modelAndView.setViewName("/productModify");
        return modelAndView;
    }


    /**
     * 提交修改后返回主界面
     */
    @RequestMapping("/submitModify")
    public ModelAndView submitModify(Product product,@RequestParam(value = "file",required = false)  MultipartFile file,
                                     HttpServletRequest request){

        String pathRoot = request.getSession().getServletContext().getRealPath("/");
        String path = "";
        //修改时插入图片
        if(file != null){
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            String contentType = file.getContentType();
            String imageName = contentType.substring(contentType.indexOf("/")+1);
            path = "/pic/"+uuid+"."+imageName;
            File newFile = new File(pathRoot + path);
            try {
                file.transferTo(newFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
            product.setPicture(path);
            try {
                productService.updateProduct(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            //图片信息不变
            try {
                productService.updateProduct(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = null;
        try {
            productList = productService.queryAllProducts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        modelAndView.addObject("productList",productList);
        modelAndView.setViewName("/productManager");
        return modelAndView;

    }


    /**
     * 删除商品
     */
    @RequestMapping("/deleteProduct")
    @ResponseBody
    public String deleteProduct(@RequestBody String[] inputs){
        //删除商品编号
        String id_str = inputs[0];
        int id = new Integer(id_str);
        try {
            productService.deleteProduct(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "productManager";
    }


    /**
     * 商品详情
     */
    @RequestMapping("/productInfo")
    public ModelAndView productInfo(@ModelAttribute Product product){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",product);
        modelAndView.setViewName("/productInfo");
        return modelAndView;
    }

}
