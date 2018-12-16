package com.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.service.IRegisterService;

/**
 * @version 时间：2018年7月4日 下午3:51:00
 *
 */
public class Test {

	public static void main(String[] args) {
		AbstractApplicationContext aac = new ClassPathXmlApplicationContext("applicationContext.xml");
		IRegisterService ihs = (IRegisterService)aac.getBean("registerService");
		System.out.println(ihs.selectAll());
	}

}
