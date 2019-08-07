package com.springboot.learn.response;

public class ResponseResult{

    private Integer code;

    private String message;

    private Object data;

    public ResponseResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, String message,Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }


    public static ResponseResult ok(){
        return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage());
    }
    public static ResponseResult ok(Object data){
        return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage(),data);
    }

    public static ResponseResult args_validate_fail(Object data){
        return new ResponseResult(CodeMessage.ARGS_VALIDATE_FAIL.getCode(),CodeMessage.ARGS_VALIDATE_FAIL.getMessage(),data);
    }

    public static ResponseResult unknown(){
        return new ResponseResult(CodeMessage.UNKNOWN.getCode(),CodeMessage.UNKNOWN.getMessage());
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

    public Object getdata() {
        return data;
    }

    public void setdata(Object data) {
        this.data = data;
    }
}
