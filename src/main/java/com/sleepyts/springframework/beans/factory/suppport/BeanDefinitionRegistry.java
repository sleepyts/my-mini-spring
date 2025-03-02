package com.sleepyts.springframework.beans.factory.suppport;


import com.sleepyts.springframework.beans.factory.config.BeanDefinition;

/**
 * 注册Bean定义的接口
 */
public interface BeanDefinitionRegistry {
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    boolean containsBeanDefinition(String beanName);
}
