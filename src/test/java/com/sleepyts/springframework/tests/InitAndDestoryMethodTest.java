package com.sleepyts.springframework.tests;


import com.sleepyts.springframework.context.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author derekyi
 * @date 2020/11/29
 */
public class InitAndDestoryMethodTest {

	@Test
	public void testInitAndDestroyMethod() throws Exception {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
		applicationContext.registerShutDownHook();  //或者手动关闭 applicationContext.close();
		Object car = applicationContext.getBean("car");
		Object car1 = applicationContext.getBean("car");

		System.out.println(car);
		System.out.println(car1);

		System.out.println(car.equals(car1));
	}
}
