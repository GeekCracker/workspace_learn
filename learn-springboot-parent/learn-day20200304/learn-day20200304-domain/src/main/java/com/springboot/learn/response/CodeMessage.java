package com.springboot.learn.response;

public enum CodeMessage {

    SUCCESS(200,"操作成功!!");

    /**状态码*/
    Integer code;
    /**状态信息*/
    String message;

    CodeMessage(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode(){
        return code;
    }
    public String getMessage(){
        return message;
    }
}
