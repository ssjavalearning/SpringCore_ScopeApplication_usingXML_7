package com.suraj.spring.client;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.suraj.spring.model.Mobile;

public class MobileTest {
	
	public static void main(String[] args) {
		ApplicationContext context = null;
		try {
			context = new ClassPathXmlApplicationContext("springs.xml");
			Mobile mobile =  context.getBean("mobile", Mobile.class);
			mobile.setMobileId(1001);
			mobile.setMobileName("MOTO G");
			System.out.println(mobile.getMobileId()+"\t"+mobile.getMobileName()); 
			
			Mobile mob = context.getBean("mobile", Mobile.class);
			//if scope=singleton then output is: 1001  MOTO G else if scope=prototype then 0  null
			System.out.println(mob.getMobileId()+"\t"+mob.getMobileName());
		} catch(BeansException e) {
			e.printStackTrace();
		} finally {
			if (context != null) {
				((AbstractApplicationContext) context).close();
			}
		}
	}
}
