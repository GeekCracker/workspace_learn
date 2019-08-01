package com.database.operation.response;

public enum CodeMessage {

    SUCCESS(200,"操作成功！");


    /**状态码*/
    private Integer code;

    /**状态信息*/
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
