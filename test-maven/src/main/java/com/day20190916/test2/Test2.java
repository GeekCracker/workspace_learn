package com.day20190916.test2;

import com.alibaba.fastjson.JSONObject;

public class Test2 {

    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username","张三");

        System.out.println(jsonObject);
        System.out.println(jsonObject.get("username"));

        User user = new User();
        user.setUsername("李四");
        String str = JSONObject.toJSONString(user);
        System.out.println(str);
    }
}
class User{

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
