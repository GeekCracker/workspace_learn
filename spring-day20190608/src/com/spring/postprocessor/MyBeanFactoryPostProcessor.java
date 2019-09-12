package com.spring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 *执行时机：在bean定义都加载到容器中去了，还没实例化时执行
 */
@Component
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor{
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("IOC容器 调用了MyPostProcessor的 postProcessBeanFactory方法");
		for(String name : beanFactory.getBeanDefinitionNames()){
			if("user".equals(name)){
				BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
				beanDefinition.setLazyInit(true);
			}
		}
		
	}
}
