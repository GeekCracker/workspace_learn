package com.day20191007.test1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test1 {
    public static void main(String[] args) {

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        for(int i = 1;i<10;i++){
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("id",i);
            if(i%2==0){
                map.put("sex","ÄÐ");
            }else {
                map.put("sex","Å®");
            }
            if(i%3==0){
                map.put("season","´º");
            }else {
                map.put("season","¶¬");
            }
            list.add(map);
        }
        String sex = "ÄÐ";
        String season = "´º";
        Stream<Map<String,Object>> stream = list.stream();
        list = stream.filter(item->
                (sex != null ? sex.equals(item.get("sex")) : true) &&
                (season != null ? season.equals(item.get("season")) : true)
        ).collect(Collectors.toList());
        list.forEach(item-> System.out.println(item));
    }
}
