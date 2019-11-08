package com.day20191104.test1.direct_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MessageConsumer {

    public static void main(String[] args) throws Exception {

        //�������ӹ����������ù�������
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("111.231.111.161");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/tuling");
        connectionFactory.setUsername("zhangsan");
        connectionFactory.setPassword("123456");

        //��������
        Connection connection = connectionFactory.newConnection();

        //�����ŵ�
        Channel channel = connection.createChannel();

        //����topic������
        String exchange = "jiaohuanji004";
        String queue = "learn-queue-day20191104";

        channel.exchangeDeclare(exchange,"topic",true,false,false,null);

        //��������
        channel.queueDeclare(queue,true,false,false,null);

        //�������������ͨ��·�ɼ���
        channel.queueBind(queue,exchange,queue);

        channel.basicConsume(queue,false,new MyConsumer(channel));

        /*//����һ��������
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //��ʼ����
        channel.basicConsume(queue,true,queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("���ܵ���Ϣ:"+new String(delivery.getBody()));
        }*/
    }
}
