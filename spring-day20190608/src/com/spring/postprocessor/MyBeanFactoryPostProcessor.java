package com.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 *ִ��ʱ������bean���嶼���ص�������ȥ�ˣ���ûʵ����ʱִ��
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("IOC���� ������MyPostProcessor�� postProcessBeanFactory����");
		for(String name : beanFactory.getBeanDefinitionNames()){
			if("user".equals(name)){
				BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
				beanDefinition.setLazyInit(true);
			}
		}
		
	}
}
