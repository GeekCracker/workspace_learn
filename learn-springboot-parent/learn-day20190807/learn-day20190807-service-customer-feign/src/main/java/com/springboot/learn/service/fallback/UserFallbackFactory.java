package com.springboot.learn.service.fallback;

import com.springboot.learn.service.UserService;
import feign.hystrix.FallbackFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable throwable) {

        System.out.println("#################");
        System.out.println(throwable.getMessage());
        return new UserService() {
            @Override
            public ResponseEntity<Object> queryById(String id) {
                System.out.println("=========走到熔断器=============");

                return new ResponseEntity<Object>(HttpStatus.OK);
            }
        };
    }
}
