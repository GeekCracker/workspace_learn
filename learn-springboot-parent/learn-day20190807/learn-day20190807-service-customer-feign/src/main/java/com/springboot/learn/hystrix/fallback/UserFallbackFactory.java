package com.springboot.learn.hystrix.fallback;

import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.UserService;
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
            public ResponseResult queryById(String id) {
                System.out.println("=========走到熔断器=============");



                return ResponseResult.unknown();
            }
        };
    }
}
