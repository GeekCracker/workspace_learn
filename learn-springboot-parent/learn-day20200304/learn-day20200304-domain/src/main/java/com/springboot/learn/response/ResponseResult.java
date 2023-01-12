package com.springboot.learn.response;

import java.io.Serializable;

public class ResponseResult implements Serializable {

    private Integer code;

    private String msg;

    private Object data;

    public ResponseResult(){
        super();
    }

    public ResponseResult(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public ResponseResult(Integer code,String msg,Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ResponseResult ok(){
        return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage());
    }

    public static ResponseResult ok(Object data){
        return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage(),data);
    }

    public static ResponseResult ok(Object data,String message){
        return new ResponseResult(CodeMessage.SUCCESS.getCode(),message,data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
