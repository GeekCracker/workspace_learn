package com.springboot.learn.admin.controller;

import com.springboot.learn.service.BaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController("AdminBaseController")
@RequestMapping("/")
public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    @GetMapping("queryById/{id}")
    public ResponseEntity<T> queryById(@PathVariable("id") String id){
        return new  ResponseEntity<T>(getService().queryById(id), HttpStatus.OK);
    }

    @ExceptionHandler
    public String doError(Exception ex) throws Exception{
        ex.printStackTrace();
        return ex.getMessage()+"我进来了";
    }


}
