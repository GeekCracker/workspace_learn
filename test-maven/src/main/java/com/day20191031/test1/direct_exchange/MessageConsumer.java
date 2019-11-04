package com.day20191031.test1.direct_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MessageConsumer {
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

        //声明队列
        String queueName = "tuling-queue-01";

        //参数列表：队列名称
        //          是否持久化队列
        //          是否是独占的，只能被一个消费者占有
        //          是否在消息消费后自动删除队列
        //          其他参数
        channel.queueDeclare(queueName,true,false,false,null);



        //创建消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //参数列表：队列名称
        //          是否自动签收，保证消息可靠性投递
        //          消费者对象
        channel.basicConsume(queueName,true,queueingConsumer);


        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String reserveMsg = new String(delivery.getBody());
            System.out.println("消费消息:"+reserveMsg);
        }

    }
}
