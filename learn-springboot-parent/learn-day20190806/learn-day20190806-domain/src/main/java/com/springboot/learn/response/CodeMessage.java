package com.springboot.learn.response;

public enum CodeMessage {

    SUCCESS(200,"操作成功！"),
    UNKNOWN(-1,"系统异常"),
    ARGS_VALIDATE_FAIL(101,"参数校验失败！"),
    ;

    private Integer code;

    private String message;

    private CodeMessage(Integer code,String message){
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
