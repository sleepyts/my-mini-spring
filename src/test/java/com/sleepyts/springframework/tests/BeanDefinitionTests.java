package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import com.sleepyts.springframework.beans.factory.suppport.DefaultListableBeanFactory;
import com.sleepyts.springframework.objects.A;
import org.junit.Test;

public class BeanDefinitionTests {
    @Test
    public void testBeanFactory() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new BeanDefinition(A.class);
        beanFactory.registerBeanDefinition("a", beanDefinition);

        A a = (A) beanFactory.getBean("a");
        a.fun();
    }


}
