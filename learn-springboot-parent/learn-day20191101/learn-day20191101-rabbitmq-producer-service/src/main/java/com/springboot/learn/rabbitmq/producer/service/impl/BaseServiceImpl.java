package com.springboot.learn.rabbitmq.producer.service.impl;

import com.springboot.learn.rabbitmq.producer.service.BaseService;
import org.springframework.transaction.annotation.Transactional;

@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl<T> implements BaseService<T> {
}
