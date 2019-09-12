package com.spring.xmlbeanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import com.spring.domain.User;

public class BeanFactoryTest {

	public static void main(String[] args) {
		Resource resource = new FileSystemResource("beans.xml");
		BeanFactory  beanFactory = new XmlBeanFactory(resource);
		User user = (User) beanFactory.getBean("user");
		System.out.println(user);
		
		BeanFactory beanFactory1 = new DefaultListableBeanFactory();
		BeanDefinitionReader bdr = new XmlBeanDefinitionReader((BeanDefinitionRegistry)beanFactory1);
		bdr.loadBeanDefinitions(resource);
		User user1 = (User)beanFactory1.getBean("user");
		System.out.println(user1);
		ApplicationContext applicationContext= new ClassPathXmlApplicationContext("cbeans.xml");
		User user2 = (User) applicationContext.getBean("user");
		System.out.println(user2);
	}
}
