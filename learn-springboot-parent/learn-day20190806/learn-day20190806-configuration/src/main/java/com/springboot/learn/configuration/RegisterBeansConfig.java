package com.springboot.learn.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
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
     * ribbon和feign
     * 1、性能：ribbon比feign性能搞50%
     * 2、使用：feign可以像调用本地服务一样来调用远程服务
     *
     *
     * */


    @Bean
    public IRule iRule(){
        IRule iRule = new RandomRule();

        //响应时间最短权重最大，概率越大
        //刚启动时,如果统计信息不足,则使用RoundRobinRule策略,等统计信息足够时,会切换到WeightedResponseTimeRule
        iRule = new WeightedResponseTimeRule();

        return iRule;
    }
}
