package com.day20191104.test1.direct_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MessageConsumer {

    public static void main(String[] args) throws Exception {

        //创建连接工厂，并设置工厂属性
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("111.231.111.161");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/tuling");
        connectionFactory.setUsername("zhangsan");
        connectionFactory.setPassword("123456");

        //创建连接
        Connection connection = connectionFactory.newConnection();

        //创建信道
        Channel channel = connection.createChannel();

        //声明topic交换机
        String exchange = "jiaohuanji004";
        String queue = "learn-queue-day20191104";

        channel.exchangeDeclare(exchange,"topic",true,false,false,null);

        //声明队列
        channel.queueDeclare(queue,true,false,false,null);

        //将交换机与队列通过路由键绑定
        channel.queueBind(queue,exchange,queue);

        channel.basicConsume(queue,false,new MyConsumer(channel));

        /*//声明一个消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //开始消费
        channel.basicConsume(queue,true,queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("接受到消息:"+new String(delivery.getBody()));
        }*/
    }
}
