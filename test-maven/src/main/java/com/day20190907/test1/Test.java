package com.day20190907.test1;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Controller
public class Test {

    private static ApplicationContext applicationContext;

    @Autowired
    Redisson redisson;

    public static void main(String[] args) {
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(MyConfig.class);
        /*User user1 = applicationContext.getBean(User.class);

        System.out.println(user1);
        User user2 = applicationContext.getBean(User.class);
        System.out.println(user2);
        System.out.println(user1 == user2);*/

        SpringApplication springApplication = new SpringApplication(Test.class);
        AnnotationConfigServletWebServerApplicationContext configurableApplicationContext = (AnnotationConfigServletWebServerApplicationContext) springApplication.run(args);
        configurableApplicationContext.publishEvent(new ApplicationEvent("发布了一个Application容器事件") {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
        DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

        Test.init(configurableApplicationContext);

/*        Test test1 = new Test();
        Test test2 = new Test();
        User user1 = test1.getUser();
        User user2 = test2.getUser();
        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user1 == user2);*/
    }
    @RequestMapping("user")
    @ResponseBody
    public User getUser(){
        User user = applicationContext.getBean(User.class);
        return user;
    }

    @RequestMapping("lock")
    @ResponseBody
    public Object rLock(){
        Redisson redisson = applicationContext.getBean(Redisson.class);
        RLock rLock = redisson.getLock("uploadLock");

        rLock.lock();
        System.out.println(rLock.getHoldCount());
        rLock.unlock();
        System.out.println(rLock.getHoldCount());
        System.out.println(redisson.isShutdown());;
        redisson.shutdown();
        return null;
//        rLock.unlock();
//        return  rKeys;
    }


    public static void init(ConfigurableApplicationContext configurableApplicationContext){
        Test.applicationContext = configurableApplicationContext;
    }
}
