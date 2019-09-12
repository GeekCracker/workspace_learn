package com.spring.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 监听器采用到的设计模式是观察者模式
 */
@Component
public class MyApplicationListener implements ApplicationListener{

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("监听器接受到了一个事件:"+event);
		System.out.println(event.getSource());
	}
}
