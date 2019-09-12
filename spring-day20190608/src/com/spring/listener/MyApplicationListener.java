package com.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ���������õ������ģʽ�ǹ۲���ģʽ
 */
@Component
public class MyApplicationListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("���������ܵ���һ���¼�:"+event);
		System.out.println(event.getSource());
	}
}
