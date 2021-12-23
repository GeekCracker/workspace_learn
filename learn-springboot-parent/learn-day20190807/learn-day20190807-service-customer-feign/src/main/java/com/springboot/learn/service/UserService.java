package com.springboot.learn.service;

import com.springboot.learn.domain.User;
import com.springboot.learn.service.fallback.UserFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "PROVIDER",fallback = UserFallBack.class)//服务提供者的服务名称
public interface UserService extends BaseService<User> {

    @GetMapping(value = "/admin/user/queryById/{id}")
    @Override
    ResponseEntity<Object> queryById(@PathVariable("id") String id);
}
