package com.spring.annotationbeanfactory;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring.annotationbeanfactory.config.BeansContextConfig;
import com.spring.domain.Person;
import com.spring.domain.User;


/**
 * ����ע��Ķ����ʼ����ʽ��Ҫ����AOP��
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
		//��ӡ�����������е�bean����
		Arrays.asList(names).forEach(item -> {
			System.out.println((index++)+":"+item);
		});
		
		acac.close();
	}
}
