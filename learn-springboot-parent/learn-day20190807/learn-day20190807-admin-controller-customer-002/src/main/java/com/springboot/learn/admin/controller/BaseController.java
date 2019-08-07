package com.springboot.learn.admin.controller;


import com.springboot.learn.response.ResponseResult;
import com.springboot.learn.service.BaseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;

@Controller("AdminBaseController")
@RequestMapping("/")
public abstract class BaseController<T> {

    protected abstract BaseService<T> getService();

    /**
     * 在这里遇到一个坑，暂时还没解决
     *      在通过feign进行远程调用时，如果服务提供者返回异常，熔断器的fallback回退机制没有生效，
     *      即使配置文件中配置了feign.hystrix.enabled=true启动熔断器，也还是没有生效
     * 目前的解决方案：服务提供者增加全局的异常处理器，拦截controller返回的异常，返回相应的信息给服务调用者，
     *                 服务调用者解析该返回结果，并返回
     * spring-cloud-starter-eureka版本：1.4.3.RELEASE
     * spring-cloud-starter-eureka-server版本：1.4.3.RELEASE
     * spring-cloud-starter-feign版本：1.4.3.RELEASE
     * spring-cloud-starter-hystrix版本：1.4.3.RELEASE
     * @param id
     * @return
     */
    @GetMapping("queryById/{id}")
    public ResponseResult queryById(@PathVariable("id") String id){
        //return ResponseResult.ok(getService().queryById(id).getdata());
        LinkedHashMap<String,Object> linkedHashMap = (LinkedHashMap<String,Object>)getService().queryById(id).getBody();
        return ResponseResult.build((Integer)linkedHashMap.get("code"),(String)linkedHashMap.get("message"),linkedHashMap.get("data"));
    }
}





