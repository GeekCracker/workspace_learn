package com.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 触发时机：在bean定义加载到IOC容器之前触发
 * 并且bean定义注册的方法先执行，然后执行bean工厂的后置处理方法
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("---该方法后执行---");
		System.out.println("IOC容器调用了MyBeanDefinitionRegistryPostProcessor的postProcessBeanFactory方法");
		System.out.println("IOC容器中Bean定义的数量："+beanFactory.getBeanDefinitionCount());
	}
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("---该方法先执行---");
		System.out.println("IOC容器调用了MyBeanDefinitionRegistryPostProcessor的postProcessBeanDefinitionRegistry方法");
	}
}
