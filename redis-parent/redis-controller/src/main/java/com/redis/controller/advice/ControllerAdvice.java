package com.redis.controller.advice;

import com.redis.exception.BizException;
import com.redis.response.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@org.springframework.web.bind.annotation.ControllerAdvice
@RestController("AdminControllerAdvice")
public class ControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseResult onException(Exception e){
        e.printStackTrace();
        if(e instanceof BizException){
            return ResponseResult.build(((BizException) e).getCodeMessage());
        }
        return ResponseResult.unknown();
    }
}
