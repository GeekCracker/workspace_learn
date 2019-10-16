package com.day20190916.test1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanFactoryTest {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =new AnnotationConfigApplicationContext(MyConfig.class);
        Bean1 bean1 = annotationConfigApplicationContext.getBean(Bean1.class);
        System.out.println(bean1);
        System.out.println(bean1.getBean2());
        System.out.println(bean1.getBean2().getBean1());

        System.out.println(bean1.getName());
        System.out.println(bean1.getBean2().getBean1().getName());
        annotationConfigApplicationContext.close();
    }
}
