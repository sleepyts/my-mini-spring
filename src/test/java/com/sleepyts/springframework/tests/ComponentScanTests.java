package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.context.ClassPathXmlApplicationContext;
import org.junit.Test;

public class ComponentScanTests {

    @Test
    public void testComponentScan() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:component-scan.xml");

        Object car = classPathXmlApplicationContext.getBean("car");
        Object car1 = classPathXmlApplicationContext.getBean("car");
        System.out.println(car.equals(car1));
    }
}
