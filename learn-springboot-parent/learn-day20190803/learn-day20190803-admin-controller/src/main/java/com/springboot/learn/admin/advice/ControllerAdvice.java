package com.springboot.learn.admin.advice;

import com.springboot.learn.response.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Controller层拦截器
 */
@Slf4j
@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {




    /**
     * 当Controller出现异常时，会走到这里，可以在这里统一处理异常
     * @param e
     * @return
     * @throws Exception
     */
    @ResponseBody
    @ExceptionHandler(value = Throwable.class)
    public ResponseResult doError(Exception e) throws Exception{
        if(e instanceof BindException){
            BindingResult result = ((BindException) e).getBindingResult();
            return  ResponseResult.args_validate_fail(validate(result));
        }
        return ResponseResult.unknown();
    }
    /**
     * 参数校验异常结果处理
     * @param result 传入参数异常的结果
     * @return 返回需要返回给前端的信息
     */
    protected Map<String,Object> validate(BindingResult result) {
        if (result.hasFieldErrors()) {
            Map<String,Object> map = new LinkedHashMap<String ,Object>();
            List<FieldError> errorList = result.getFieldErrors();
            for (FieldError fieldError : errorList){
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return  map;
        }
        return  new LinkedHashMap<String, Object>();
    }
}
