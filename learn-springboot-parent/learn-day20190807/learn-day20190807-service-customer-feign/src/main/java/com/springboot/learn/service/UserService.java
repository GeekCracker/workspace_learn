package com.springboot.learn.service;

import com.springboot.learn.domain.User;
import com.springboot.learn.hystrix.fallback.UserFallbackFactory;
import com.springboot.learn.response.ResponseResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "PROVIDER",fallbackFactory = UserFallbackFactory.class)//服务提供者的服务名称
public interface UserService extends BaseService<User>{

    @GetMapping(value = "/admin/user/queryById/{id}")
    ResponseResult queryById(@PathVariable("id") String id);
}

