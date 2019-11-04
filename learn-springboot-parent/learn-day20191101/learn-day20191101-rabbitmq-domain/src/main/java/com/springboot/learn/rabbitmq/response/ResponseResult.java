package com.springboot.learn.rabbitmq.response;

public class ResponseResult {

    private Integer code;

    private String message;

    private Object data;

    public ResponseResult(Object data) {
        this.data = data;
    }

    public ResponseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResponseResult success(){
        return new ResponseResult(MessageCode.SUCCESS.getCode(),MessageCode.SUCCESS.getMessage());
    }
    public static ResponseResult success(Object data){
        return new ResponseResult(MessageCode.SUCCESS.getCode(),MessageCode.SUCCESS.getMessage(),data);
    }

    public static ResponseResult failure(){
        return new ResponseResult(MessageCode.FAILURE.getCode(),MessageCode.FAILURE.getMessage());
    }
    public static ResponseResult failure(Object data){
        return new ResponseResult(MessageCode.FAILURE.getCode(),MessageCode.FAILURE.getMessage(),data);
    }

    public static ResponseResult unknown(){
        return new ResponseResult(MessageCode.UNKNOWN.getCode(),MessageCode.UNKNOWN.getMessage());
    }

    public static ResponseResult unknown(Object data){
        return new ResponseResult(MessageCode.UNKNOWN.getCode(),MessageCode.UNKNOWN.getMessage(),data);
    }

    public static ResponseResult build(MessageCode messageCode){
        return new ResponseResult(messageCode.getCode(),messageCode.getMessage());
    }
    public static ResponseResult build(MessageCode messageCode,Object data){
        return new ResponseResult(messageCode.getCode(),messageCode.getMessage(),data);
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
