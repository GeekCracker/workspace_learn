package com.springboot.learn.service;

import com.springboot.learn.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @description: 用户Service
 * @author: 朱俊亮
 * @time: 2020/3/20 9:16
 */
@FeignClient(value = "core-service")
public interface UserService {

    @PutMapping("/core/write/user/save")
    void save(User user);
}
