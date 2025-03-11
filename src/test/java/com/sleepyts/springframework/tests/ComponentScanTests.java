package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.context.ClassPathXmlApplicationContext;
import com.sleepyts.springframework.services.WorldService;
import org.junit.Test;

public class ComponentScanTests {

    @Test
    public void testComponentScan() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:component-scan.xml");
        WorldService worldService = classPathXmlApplicationContext.getBean("WorldServiceImpl", WorldService.class);
        worldService.explode();
    }
}
