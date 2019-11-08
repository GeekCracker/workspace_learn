package com.day20191104.test1.direct_exchange;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

import java.io.IOException;

public class MyConsumer extends DefaultConsumer {

    private Channel channel;

    public MyConsumer(Channel channel) {
        super(channel);
        this.channel = channel;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        //super.handleDelivery(consumerTag, envelope, properties, body);

        try {
            Integer index = (Integer)properties.getHeaders().get("index");
            if(index != 0){
                System.out.println("消费消息"+new String(body));
                channel.basicAck(envelope.getDeliveryTag(),false);
            }else {
                throw new RuntimeException();
            }
        }catch (Exception e){
            System.out.println("异常消费消息"+new String(body));
            //参数列表：上游ack唯一性id，是否批量签收，是否重回队列(消费失败后重新消费)
            channel.basicNack(envelope.getDeliveryTag(),false,false);
        }
    }
}
