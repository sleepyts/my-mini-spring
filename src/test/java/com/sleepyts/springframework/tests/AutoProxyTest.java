package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.context.ClassPathXmlApplicationContext;
import com.sleepyts.springframework.services.WorldService;
import com.sleepyts.springframework.services.WorldServiceImpl;
import org.junit.Test;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class AutoProxyTest {

    @Test
    public void testAutoProxy() throws Exception {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:auto-proxy.xml");

        //获取代理对象
        WorldServiceImpl worldService = applicationContext.getBean("worldService", WorldServiceImpl.class);
        worldService.explode();
    }
}
