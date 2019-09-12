package com.spring.annotationbeanfactory.config;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 如果matches返回true，则表示进行引入组件
 */
public class MyConditional implements Condition{

	@Override
	public boolean matches(ConditionContext arg0, AnnotatedTypeMetadata arg1) {
		return true;
	}
}
