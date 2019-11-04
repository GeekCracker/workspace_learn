package com.springboot.learn.rabbitmq.producer.advice;

import com.springboot.learn.rabbitmq.exception.BizException;
import com.springboot.learn.rabbitmq.response.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseResult onError(Exception exception){
        exception.printStackTrace();
        if(exception instanceof BizException){
            return ResponseResult.build(((BizException) exception).getMessageCode());
        }else {
            return ResponseResult.unknown();
        }
    }
}
