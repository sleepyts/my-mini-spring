package com.sleepyts.springframework.beans.factory.config;

import com.sleepyts.springframework.beans.factory.BeanFactory;
import com.sleepyts.springframework.beans.factory.suppport.ListableBeanFactory;

public interface ConfigurableListableBeanFactory extends AutowireCapableBeanFactory, ConfigurableBeanFactory, ListableBeanFactory {

    /**
     * 查找Bean
     * @param name
     * @return
     */
    BeanDefinition getBeanDefinitionByName(String name);

    /**
     * 提前实例化所有单例bean
     */
    void preInstantiateSingletons();

}
