package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory {

    BeanInstantiationStrategy simple=new CglibBeanInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = simple.instance(beanDefinition);
        } catch (Exception e) {

        }
        registerSingleton(beanName,bean);
        return bean;
    }
}
