package com.day20191104.test1.direct_exchange;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import javax.jms.DeliveryMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class MessageProducer {
    public static void main(String[] args) throws Exception{

        //创建连接工厂，并设置工厂属性
        ConnectionFactory connectionFactory= new ConnectionFactory();
        connectionFactory.setHost("111.231.111.161");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/tuling");
        connectionFactory.setUsername("zhangsan");
        connectionFactory.setPassword("123456");

        //创建连接
        Connection connection = connectionFactory.newConnection();

        //创建信道
        Channel channel = connection.createChannel();

        //发送消息
        for(int i=0;i<1;i++){
            Map<String,Object> headers = new LinkedHashMap<>();
            headers.put("msg","第"+i+"条消息");
        //    headers.put("blob",("第"+i+"条消息").getBytes());

            AMQP.BasicProperties properties = new AMQP.BasicProperties().builder()
                    .deliveryMode(DeliveryMode.NON_PERSISTENT)//持久化消息
                    .contentEncoding("UTF-8")
                    .correlationId(UUID.randomUUID().toString())
                    .contentType("text/html;charset=utf-8")
                    .headers(headers)
                    .build();
            //channel.basicPublish("jiaohuanji004","learn-queue-day20191104",properties,null);
            channel.basicPublish("jiaohuanji004","learn-queue-day20191104",properties,("第"+i+"条消息").getBytes());
        }

        //关闭链接
        channel.close();
        connection.close();
    }
}
