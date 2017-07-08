package com.gushuai.ssm.exception;

/**
 * Created by asus on 2017/7/6.
 */
public class CustomException extends Exception{

    //异常信息
    public String message;


    public CustomException(String message) {
        super(message);
        this.message = message;
    }


    @Override
    public String getMessage() {
        return message;
    }


    public void setMessage(String message) {
        this.message = message;
    }



}
