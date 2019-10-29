package com.day20191029.test1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Scanner;

public class MessageProvider {

    private static String brokerURL = "tcp://localhost:61616";
    private static String queueName = "queue-test";
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception{
        publishMessage();
    }

    public static void publishMessage()throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageProducer producer = session.createProducer(destination);

        while (true){
           String message =  scanner.nextLine();
            TextMessage textMessage = session.createTextMessage();
            textMessage.setStringProperty("msg",message);
            producer.send(textMessage);
            if("exit".equals(message)){
                break;
            }
        }
        connection.close();
    }
}
