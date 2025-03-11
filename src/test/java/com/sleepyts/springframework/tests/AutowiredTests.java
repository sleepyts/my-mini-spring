package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.context.ClassPathXmlApplicationContext;
import com.sleepyts.springframework.objects.Car;
import org.junit.Test;

public class AutowiredTests {
    @Test
    public void testAutowire() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:component-scan.xml");
        Car car = classPathXmlApplicationContext.getBean("car", Car.class);
        car.getPerson().sayHello();

    }
}
