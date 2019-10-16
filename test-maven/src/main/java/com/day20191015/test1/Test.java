package com.day20191015.test1;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        test1();
    }

    public static void test1(){

        List<User> list = new LinkedList<>();
        list.add(new User(1,1,"��һ"));
        list.add(new User(2,1,"�Ŷ�"));
        list.add(new User(3,2,"����"));
        list.add(new User(4,2,"����"));

        Map<Integer,List<User>> map = list.stream().filter(item->item.getId()>1).collect(Collectors.groupingBy(User::getModuleId));

        System.out.println(map);
    }
}

