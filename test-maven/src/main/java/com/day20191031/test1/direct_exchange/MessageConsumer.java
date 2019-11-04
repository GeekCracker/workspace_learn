package com.day20191031.test1.direct_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

public class MessageConsumer {
    public static void main(String[] args)throws Exception {
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

        //��������
        String queueName = "tuling-queue-01";

        //�����б���������
        //          �Ƿ�־û�����
        //          �Ƿ��Ƕ�ռ�ģ�ֻ�ܱ�һ��������ռ��
        //          �Ƿ�����Ϣ���Ѻ��Զ�ɾ������
        //          ��������
        channel.queueDeclare(queueName,true,false,false,null);



        //����������
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //�����б���������
        //          �Ƿ��Զ�ǩ�գ���֤��Ϣ�ɿ���Ͷ��
        //          �����߶���
        channel.basicConsume(queueName,true,queueingConsumer);


        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            String reserveMsg = new String(delivery.getBody());
            System.out.println("������Ϣ:"+reserveMsg);
        }

    }
}
