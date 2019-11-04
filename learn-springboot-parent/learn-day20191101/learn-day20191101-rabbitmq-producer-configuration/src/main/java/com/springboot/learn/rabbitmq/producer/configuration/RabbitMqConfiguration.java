package com.springboot.learn.rabbitmq.producer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfiguration {

    // 交换机有四种类型,分别为
    // 直连交换机Direct
    //  直连交换机根据消息携带的路由键将消息投递给对应队列，如果消息没有消费，则消息不会删除

    // 扇形交换机Fanout
    //
    // 主题交换机topic
    // 首部交换机headers

    // Direct 模式创建队列
    // 创建队列
    @Bean
    public Queue queue() {
        return new Queue("learn-queue-day20191101",true);
    }

    // 创建一个直接交换机
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("jiaohuanji001",true,false);
    }

    // 把队列和交换机绑定在一起
    @Bean
    public Binding testBinding(Queue queue, DirectExchange exchange) {
        System.out.println("=====将交换机["+queue.getActualName()+"]与队列"+exchange.getName()+"通过路由键绑定====");
        return BindingBuilder.bind(queue).to(exchange).with("learn-queue-day20191101");
    }
}
