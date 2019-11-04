package com.day20191031.test1.topic_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.util.Scanner;

public class MessageProducer {
    private static Scanner scanner = new Scanner(System.in);
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


        //������Ϣ
        String exchangeName = "jiaohuanji002";

        String routingKey1 = "learn.001";
        String routingKey2 = "learn.topic.002";
        String routingKey3 = "learn.topic.003";

        String message = null;
        while (true){
            message = scanner.nextLine();
            if("exit".equals(message)){
                break;
            }
            channel.basicPublish(exchangeName,routingKey1,null,("���ǵ�һ����Ϣ"+message).getBytes());
            channel.basicPublish(exchangeName,routingKey2,null,("���ǵڶ�����Ϣ"+message).getBytes());
            channel.basicPublish(exchangeName,routingKey3,null,("���ǵ�������Ϣ"+message).getBytes());
        }
    }
}
