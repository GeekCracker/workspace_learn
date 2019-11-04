package com.day20191031.test1.fanout_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MessageConsumer {

    public static void main(String[] args) throws Exception {
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

        //创建交换机
        channel.exchangeDeclare("jiaohuanji003","fanout",true,false,false,null);
        //创建队列
        channel.queueDeclare("test.fanout.queue",true,false,true,null);
        //绑定队列
        channel.queueBind("test.fanout.queue","jiaohuanji003","");

        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);
        channel.basicConsume("test.fanout.queue",true,queueingConsumer);
        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println(new String(delivery.getBody()));
        }

    }
}
