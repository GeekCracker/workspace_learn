# learn-springboot-parent(用来学习spring-boot框架的父工程)
  说明：包含spring-cloud全家桶eureka、ribbon、feign、hystirx、zuul、security等
  =====
# 目录：
### [2019年8月](#1learn-day20190801)
   * [learn-day20190801](#1learn-day20190801) [learn-day20190803](#2learn-day20190803) [learn-day20190805](#3learn-day20190805) [learn-day20190806](#4learn-day20190806) [learn-day20190807](#5learn-day20190807)
## 1、[learn-day20190801](learn-day20190801)
     spring-boot 参数校验@Valid、控制层@ControllerAdvice拦截器、异常处理@ExceptionHandler等注解的使用
* [返回目录](#2019年8月)
## 2、[learn-day20190803](learn-day20190803)
     spring-boot 请求拦截器HandlerInterceptor接口的使用，以及通过WebMvcConfigurer接口的addInterceptors方法进行拦截器的注册
* [返回目录](#2019年8月)
## 3、[learn-day20190805](learn-day20190805)
     spring-cloud 基本用法，包含三个服务提供者和一个服务消费者，服务注册中心采用eureka，采用Ribbon的随机负载均衡策略
* [返回目录](#2019年8月)
## 4、[learn-day20190806](learn-day20190806)
     spring-cloud 基本用法，包含三个服务提供者和两个服务消费者，boot-004是采用ribbon客户端调用服务，boot-005是采用feign客户端调用服务，
     服务注册中心采用eureka，采用Ribbon的随机负载均衡策略，并采用了security认证，注册中心页面需要登录才能进入
* [返回目录](#2019年8月)
## 5、[learn-day20190807](learn-day20190807)
     spring-cloud 基本用法，包含三个服务提供者和两个服务消费者，
     customer-001采用ribbon客户端调用服务，customer-002采用feign客户端调用服务，服务注册中心采用eureka，
     两个客户端分别引入了相应的Hystrix熔断器实现方式，
     当服务提供者发生异常或客户端访问服务端连接超时，会触发fallback回退机制指定的方法
     注意：
    •2019-08-07
    在这里遇到一个坑，暂时还没解决：
           在通过feign进行远程调用时，如果服务提供者返回异常，熔断器的fallback回退机制没有生效，
           即使配置文件中配置了feign.hystrix.enabled=true启动熔断器，也还是没有生效
     目前的解决方案：服务提供者增加全局的异常处理器，拦截controller返回的异常，返回相应的信息给服务调用者，
                   服务调用者解析该返回结果，并返回
     spring-cloud-starter-eureka版本：1.4.3.RELEASE
     spring-cloud-starter-eureka-server版本：1.4.3.RELEASE
     spring-cloud-starter-feign版本：1.4.3.RELEASE
     spring-cloud-starter-hystrix版本：1.4.3.RELEASE
     引入依赖时需要updates的版本:2.1.2.RELEASE（详见maven仓库以及父工程pom.xml文件）
* [返回目录](#2019年8月)


#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
#
# 
* [返回目录](#目录)
