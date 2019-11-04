package com.day20191031.test1.direct_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

public class MessageProducer {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)throws Exception {
        //1:创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2:设置连接工厂属性
        connectionFactory.setHost("111.231.111.161");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/tuling");
        connectionFactory.setUsername("zhangsan");
        connectionFactory.setPassword("123456");

        //3:通过连接工厂创建连接对象
        Connection connection = connectionFactory.newConnection();
        //4:通过连接创建channel
        Channel channel = connection.createChannel();

        String message = null;
        while (true){
            message = scanner.nextLine();
            if("exit".equals(message)){
               break;
            }
            channel.basicPublish("jiaohuanji001","tuling-queue-01",null,message.getBytes());
        }


        //6:关闭连接
        channel.close();
        connection.close();

    }
}
