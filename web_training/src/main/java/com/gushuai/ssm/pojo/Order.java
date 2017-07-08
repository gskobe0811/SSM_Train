package com.gushuai.ssm.pojo;



/**
 * Created by asus on 2017/7/3.
 */
public class Order {

    private int id;
    private int userId;
    private int commodityId;
    private String orderTime;
    private float orderPrice;
    private String address;
    private int telPhone;
    private String state;
    private int proCount;
    private String proName;
    private String username;
    private int labelBuy;

    public int getLabelBuy() {
        return labelBuy;
    }

    public void setLabelBuy(int labelBuy) {
        this.labelBuy = labelBuy;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public int getProCount() {
        return proCount;
    }

    public void setProCount(int proCount) {
        this.proCount = proCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCommodityId() {
        return commodityId;
    }

    public void setCommodityId(int commodityId) {
        this.commodityId = commodityId;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(int telPhone) {
        this.telPhone = telPhone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
