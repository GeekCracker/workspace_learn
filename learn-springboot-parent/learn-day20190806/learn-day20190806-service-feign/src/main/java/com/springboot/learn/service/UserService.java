package com.springboot.learn.service;

import com.springboot.learn.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("PROVIDER")//服务提供者的服务名称
public interface UserService extends BaseService<User>{

    @GetMapping(value = "/admin/user/queryById/{id}")
    ResponseEntity<Object> queryById(@PathVariable("id") String id);
}
