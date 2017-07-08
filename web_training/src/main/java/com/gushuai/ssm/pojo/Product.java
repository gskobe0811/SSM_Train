package com.gushuai.ssm.pojo;

/**
 * Created by asus on 2017/6/27.
 * 商品pojo
 */
public class Product {

    private int id;
    private String productName;
    private float price;
    private String detail;
    private String picture;
    private int productCount;
    private String productType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", detail='" + detail + '\'' +
                ", picture='" + picture + '\'' +
                ", productCount=" + productCount +
                ", productType='" + productType + '\'' +
                '}';
    }
}
