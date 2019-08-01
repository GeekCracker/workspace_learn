package com.database.operation.response;

public class ResponseResult {

    /**状态码*/
    private Integer code;

    /**状态信息*/
    private String message;

    /**返回数据*/
    private Object object;

    public ResponseResult(){}

    public ResponseResult(Integer code,String message){
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code,String message,Object object){
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public static ResponseResult ok(){
        return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage());
    }

    public static ResponseResult ok(Object object){
        return new ResponseResult(CodeMessage.SUCCESS.getCode(),CodeMessage.SUCCESS.getMessage(),object);
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
