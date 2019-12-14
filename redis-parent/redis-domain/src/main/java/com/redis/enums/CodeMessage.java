package com.redis.enums;

public enum CodeMessage {

    SUCCESS(200,"操作成功!"),
    UNKNOWN(-1,"系统异常，请重试..."),
    USERNAME_PASSWORD_IS_BLANK(-2,"用户名或密码不能为空"),
    USERNAME_PASSWORD_IS_ERROR(-3,"用户名或密码不正确"),
    UPLOAD_FILE_EMPTY(-4,"上传文件内容为空"),
    ;

    /**状态*/
    private Integer code;

    /**信息*/
    private String message;

    private CodeMessage(Integer code, String message){
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
