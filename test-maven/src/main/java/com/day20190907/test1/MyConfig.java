package com.day20190907.test1;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.Order;

@Configuration
@Order(1)
public class MyConfig extends CachingConfigurerSupport {

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public User user(){
        User user = new User();
        user.setUsername("����");
        user.setAge((int)Math.ceil(Math.random()*30));
        user.setSex("��");
        System.out.println("======user�����ʼ����======");
        return user;
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Redisson redisson(){
        Config config = new Config();
        config.useSingleServer().setAddress("redis://47.111.96.15:6379").setDatabase(0).setKeepAlive(true);
        System.out.println("====Redisson��ʼ����====");
        return (Redisson) Redisson.create(config);
    }
}
