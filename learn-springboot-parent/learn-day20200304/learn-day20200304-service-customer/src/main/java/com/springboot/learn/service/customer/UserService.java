package com.springboot.learn.service.customer;

import com.springboot.learn.domain.User;
import com.springboot.learn.service.customer.fallback.UserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-provider",fallbackFactory = UserFallbackFactory.class)//服务提供者的服务名称
public interface UserService extends BaseService<User> {
}
