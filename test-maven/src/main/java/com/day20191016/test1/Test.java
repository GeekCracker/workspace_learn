package com.day20191016.test1;

import org.springframework.data.redis.connection.ReactiveListCommands;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

public class Test {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("\\");
        list.add("-");
        list.add("+");

        Pattern pattern = Pattern.compile("^[-\\\\+]s*");
        for(String str : list){
            if(pattern.matcher(str).matches()){
                System.out.println("∆•≈‰µΩ£∫"+str);
            }
        }
    }
}
