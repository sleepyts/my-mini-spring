package com.sleepyts.springframework.beans.factory.suppport;

/**
 * SingletonBeanRegistry接口，用于注册单例Bean
 */
public interface SingletonBeanRegistry {

    public Object getSingleton(String beanName);
}
