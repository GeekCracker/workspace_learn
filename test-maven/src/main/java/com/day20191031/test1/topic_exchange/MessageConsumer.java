package com.day20191031.test1.topic_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MessageConsumer {
    public static void main(String[] args) throws Exception {

        //1:�������ӹ���
        ConnectionFactory connectionFactory = new ConnectionFactory();
        //2:�������ӹ�������
        connectionFactory.setHost("111.231.111.161");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/tuling");
        connectionFactory.setUsername("zhangsan");
        connectionFactory.setPassword("123456");

        //3:ͨ�����ӹ����������Ӷ���
        Connection connection = connectionFactory.newConnection();
        //4:ͨ�����Ӵ���channel
        Channel channel = connection.createChannel();

        //����һ���������͵Ľ�����
        channel.exchangeDeclare("jiaohuanji002","topic",true,false,false,null);

        //����һ����Ϣ����
        channel.queueDeclare("learn-topic-queue-day20191031",true,true,false,null);

        //��������������Ϣ���еİ󶨹�ϵ
        String bindStr = "learn.#";
        //channel.exchangeBind("jiaohuanji002","learn-topic-queue-day20191031",bindStr);
        channel.queueBind("learn-topic-queue-day20191031","jiaohuanji002",bindStr);

        //����һ��������
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //��ʼ����
        /**
         * ��ʼ����
         */
        channel.basicConsume("learn-topic-queue-day20191031",true,queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("���ܵ���Ϣ:"+new String(delivery.getBody()));
        }
    }

}
