package com.springboot.learn.admin.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springboot.learn.domain.User;
import com.springboot.learn.response.ResponseResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;

@RestController("AdminUserController")
@RequestMapping("/admin/user")
public class UserController extends BaseController<User>{


    @GetMapping("queryById/{id}")
    @HystrixCommand(fallbackMethod = "fallbackMethod")//采用Ribbon方式，如果触发熔断的条件，则会触发指定的方法
    public ResponseResult queryById(@PathVariable("id") String id){
        ResponseEntity<Object> responseEntity = restTemplate.getForEntity("http://PROVIDER/admin/user/queryById/"+id,Object.class);

        //在这里制造一个异常来测试熔断器
        /*int i = 0;
        i = 1/i;
*/
        return ResponseResult.ok(((LinkedHashMap<String,Object>)responseEntity.getBody()).get("data"));
    }

    public ResponseResult fallbackMethod(String id){

        return ResponseResult.unknown();
    }
}
