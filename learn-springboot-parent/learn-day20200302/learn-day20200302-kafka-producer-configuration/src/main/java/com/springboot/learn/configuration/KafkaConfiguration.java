package com.springboot.learn.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfiguration {
    
    @Bean
    public KafkaTemplate<String,String> kafkaTemplate(ProducerFactory producerFactory){
        return new KafkaTemplate<String,String>(producerFactory);
    }
}
