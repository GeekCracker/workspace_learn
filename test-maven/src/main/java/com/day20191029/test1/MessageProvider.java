package com.day20191029.test1;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQSession;

import javax.jms.Destination;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MessageProvider {

    private static String brokerURL = "tcp://localhost:61616";
    private static String queueName = "queue-test";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        publishMessage();
    }

    public static void publishMessage()throws Exception{
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        //创建连接后会启动一个基于指定协议的socket连接，并放到线程中运行,同时启动服务的监听器
        ActiveMQConnection connection = (ActiveMQConnection)connectionFactory.createConnection();
        connection.start();//启动定时任务
        Thread.sleep(Integer.MAX_VALUE);
        new HashSet<String>().addAll(new HashSet<String>());
        ActiveMQSession session = (ActiveMQSession)connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageProducer producer = session.createProducer(destination);

        /*int i = 1;
        while (true){
            String message =  scanner.nextLine();
             message = i+"";
            if(i>100){
                break;
            }
            i++;
            TextMessage textMessage = session.createTextMessage();
            textMessage.setStringProperty("msg",message);
            producer.send(textMessage);
            if("exit".equals(message)){
                break;
            }
        }*/
        connection.close();
    }
}
