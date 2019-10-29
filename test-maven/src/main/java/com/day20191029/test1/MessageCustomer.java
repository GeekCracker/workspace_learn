package com.day20191029.test1;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MessageCustomer {

    private static String brokerURL = "tcp://localhost:61616";
    private static String queueName = "queue-test";

    public static void main(String[] args) throws Exception{
        acceptMessage();
    }
    public static void acceptMessage() throws Exception{
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createQueue(queueName);
        MessageConsumer consumer = session.createConsumer(destination);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    String msg = message.getStringProperty("msg");
                    if("exit".equals(msg)){
                        connection.close();
                    }else {
                        System.out.println(msg);
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
