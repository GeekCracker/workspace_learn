package com.day20191031.test1.topic_exchange;

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

        //声明一个主题类型的交换机
        channel.exchangeDeclare("jiaohuanji002","topic",true,false,false,null);

        //声明一个消息队列
        channel.queueDeclare("learn-topic-queue-day20191031",true,true,false,null);

        //建立交换机与消息队列的绑定关系
        String bindStr = "learn.#";
        //channel.exchangeBind("jiaohuanji002","learn-topic-queue-day20191031",bindStr);
        channel.queueBind("learn-topic-queue-day20191031","jiaohuanji002",bindStr);

        //声明一个消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //开始消费
        /**
         * 开始消费
         */
        channel.basicConsume("learn-topic-queue-day20191031",true,queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("接受到消息:"+new String(delivery.getBody()));
        }
    }

}
