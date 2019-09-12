package com.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * ����ʱ������bean������ص�IOC����֮ǰ����
 * ����bean����ע��ķ�����ִ�У�Ȼ��ִ��bean�����ĺ��ô�����
 */
@Component
public class MyBeanDefinitionRegistryPostProcessor implements BeanDefinitionRegistryPostProcessor{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("---�÷�����ִ��---");
		System.out.println("IOC����������MyBeanDefinitionRegistryPostProcessor��postProcessBeanFactory����");
		System.out.println("IOC������Bean�����������"+beanFactory.getBeanDefinitionCount());
	}
	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		System.out.println("---�÷�����ִ��---");
		System.out.println("IOC����������MyBeanDefinitionRegistryPostProcessor��postProcessBeanDefinitionRegistry����");
	}
}
