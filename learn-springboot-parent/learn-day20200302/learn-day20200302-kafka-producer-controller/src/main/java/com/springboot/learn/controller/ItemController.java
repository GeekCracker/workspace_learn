package com.springboot.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.springboot.learn.domain.ItemDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/producer/item")
public class ItemController extends BaseController {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("send")
    public void send(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Long itemId = 1L;
                while (true){
                    try {
                        ItemDto itemDto = new ItemDto();
                        itemDto.setItemId(itemId);
                        itemId++;
                        itemDto.setCode("JD301B52Y25"+itemId);
                        itemDto.setTitle("商品标题abc JD301B52Y25"+itemId);
                        kafkaTemplate.send("data-center-topic-item", JSONObject.toJSONString(itemDto));
                        System.out.println("send message ok!!");
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        String key = "itemId";
        key = key.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase();
        System.out.println(key);
    }
}
