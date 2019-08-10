package com.springboot.learn.service.fallback;

import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class UserFallBack implements UserService {

    Logger logger = LoggerFactory.getLogger(UserFallBack.class);

    @Override
    public ResponseEntity<Object> queryById(String id) {
        logger.debug("========走到熔断器=======");
        ResponseEntity responseEntity = new ResponseEntity(ResponseResult.ok("Hello World!"),null, HttpStatus.OK);
        return responseEntity;
    }
}
