package com.whitelist.mysql.response;

public enum CodeMessage {

    SUCCESS(200,"操作成功！"),
    UNKNOWN(-1,"系统异常"),
    ARGS_VALIDATE_FAIL(101,"参数校验失败！"),

    TABLE_ANNOTATION_NOT_FOUND(1002 , "domain实体上的table注解不存在,请添加..."),

    QUERY_FIELDS_NOT_FOUND(1003 , "select语句中没有查询的字段"),
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
