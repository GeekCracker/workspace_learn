package com.day20190803.test3;

import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        test1();

    }

    public static void test1(){
        String sql1 = "GRANT ALL PRIVILEGES ON *.* TO 'lxerp_dev'@'%' IDENTIFIED BY '123456' WITH GRANT OPTION;";
        Boolean cout1 = JDBCUtils.doUpdate(sql1);
        String sql2 = "flush privileges;";
        Boolean cout2 = JDBCUtils.doUpdate(sql2);
        System.out.println(cout1);
        System.out.println(cout2);
    }
    public static void test2(){
        List<Map<String,Object>> list = JDBCUtils.doQuery("select * from t_user");
        list.forEach(item-> System.out.println(item));
    }
}
