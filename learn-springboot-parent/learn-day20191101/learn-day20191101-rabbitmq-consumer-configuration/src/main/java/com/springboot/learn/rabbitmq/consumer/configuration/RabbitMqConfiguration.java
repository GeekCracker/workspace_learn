package com.springboot.learn.rabbitmq.consumer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    // 交换机有四种类型,分别为Direct,topic,headers,Fanout.

    // Direct 模式创建队列
    // 创建队列
    @Bean
    public Queue queue() {
        return new Queue("learn-queue-day20191101",true);
    }

    // 创建一个交换机
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("jiaohuanji001",true,false);
    }

    // 把队列和交换机绑定在一起
    @Bean
    public Binding testBinding(Queue queue, DirectExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("learn-queue-day20191101");
    }
}
