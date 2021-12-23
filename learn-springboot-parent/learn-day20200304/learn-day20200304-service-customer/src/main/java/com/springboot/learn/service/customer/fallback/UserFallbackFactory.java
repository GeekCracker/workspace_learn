package com.springboot.learn.service.customer.fallback;

import com.springboot.learn.domain.User;
import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.customer.UserService;
import feign.hystrix.FallbackFactory;

import org.springframework.stereotype.Component;

@Component
public class UserFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {

        System.out.println("#################");
        System.out.println(throwable.getMessage());
        return new UserService() {
            @Override
            public ResponseResult queryById(Long id) {
                return ResponseResult.ok(id,"后台异常...");
            }
        };
    }
}
