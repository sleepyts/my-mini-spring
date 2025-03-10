package com.sleepyts.springframework.tests;


import com.sleepyts.springframework.beans.factory.suppport.DefaultListableBeanFactory;
import com.sleepyts.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import com.sleepyts.springframework.objects.Car;
import com.sleepyts.springframework.objects.Person;
import org.junit.Test;

public class XmlFileDefineBeanTest {

    @Test
    public void testXmlFile() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);

        beanDefinitionReader.loadBeanDefinitions("classpath:spring.xml");

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);

        Car car = beanFactory.getBean("car", Car.class);
        System.out.println(car);
    }
}