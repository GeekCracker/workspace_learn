package com.springboot.learn.rabbitmq.response;

public enum  MessageCode {

    SUCCESS(200,"操作成功!"),

    FAILURE(300,"操作失败!"),

    UNKNOWN(-1,"未知的异常");

    private Integer code;

    private String message;

    private MessageCode(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
