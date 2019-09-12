package com.spring.annotationbeanfactory;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.annotationbeanfactory.config.BeansContextConfig;
import com.spring.domain.Person;
import com.spring.domain.User;


/**
 * 基于注解的对象初始化方式需要加入AOP包
 * @author Geek
 */
public class BeanFactoryTest {
	private static Integer index = 0;

	public static void main(String[] args) {
		AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(BeansContextConfig.class);
		/*User user1 = (User) acac.getBean("user");
		System.out.println(user1);*/
		Person person1 = (Person) acac.getBean("person");
		System.out.println(person1);
		String[] names = acac.getBeanDefinitionNames();
		//打印出容器中所有的bean名称
		Arrays.asList(names).forEach(item -> {
			System.out.println((index++)+":"+item);
		});
		
		acac.close();
	}
}
