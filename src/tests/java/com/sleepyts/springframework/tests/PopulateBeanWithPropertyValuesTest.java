package com.sleepyts.springframework.tests;

import com.sleepyts.springframework.beans.factory.PropertyValue;
import com.sleepyts.springframework.beans.factory.PropertyValues;
import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import com.sleepyts.springframework.beans.factory.suppport.DefaultListableBeanFactory;
import com.sleepyts.springframework.objects.Person;
import org.junit.Test;


import static org.assertj.core.api.Assertions.assertThat;


public class PopulateBeanWithPropertyValuesTest {

    @Test
    public void testPopulateBeanWithPropertyValues() throws Exception {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "derek"));
        propertyValues.addPropertyValue(new PropertyValue("age", 18));
        BeanDefinition beanDefinition = new BeanDefinition(Person.class, propertyValues);
        beanFactory.registerBeanDefinition("person", beanDefinition);

        Person person = (Person) beanFactory.getBean("person");
        System.out.println(person);
        assertThat(person.getName()).isEqualTo("derek");
        assertThat(person.getAge()).isEqualTo(18);
    }
}
