package com.gushuai.ssm.pojo;

/**
 * Created by asus on 2017/7/3.
 * 购买商品下订单时信息
 */
public class OrderDetail {

    private String proName;
    private float proPrice;
    private String buyer;
    private String adderss;
    private int count;
    private int telPhone;


    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public float getProPrice() {
        return proPrice;
    }

    public void setProPrice(float proPrice) {
        this.proPrice = proPrice;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public int getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(int telPhone) {
        this.telPhone = telPhone;
    }

    public String getAdderss() {
        return adderss;
    }

    public void setAdderss(String adderss) {
        this.adderss = adderss;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    @Override
    public String toString() {
        return "OrderDetail{" +
                "proName='" + proName + '\'' +
                ", proPrice=" + proPrice +
                ", buyer='" + buyer + '\'' +
                ", telPhone=" + telPhone +
                ", adderss='" + adderss + '\'' +
                ", count=" + count +
                '}';
    }
}
