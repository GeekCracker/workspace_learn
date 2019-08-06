package com.springboot.learn.configuration;

import com.netflix.loadbalancer.*;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RegisterBeansConfig {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * @return
     */
    @Bean
    public IRule iRule(){
        IRule iRule = new RandomRule();//随机负载均衡策略
        //iRule = new WeightedResponseTimeRule();//最短响应时间权重策略，每30秒计算一次权重，响应时间最短，权重越大
        //iRule = new RoundRobinRule();//线性轮询策略

        return iRule;
    }
}
