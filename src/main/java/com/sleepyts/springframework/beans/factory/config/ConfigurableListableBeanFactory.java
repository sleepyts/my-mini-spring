package com.sleepyts.springframework.beans.factory.config;

import com.sleepyts.springframework.beans.factory.BeanFactory;
import com.sleepyts.springframework.beans.factory.suppport.ListableBeanFactory;

public interface ConfigurableListableBeanFactory extends AutowireCapableBeanFactory, ConfigurableBeanFactory, ListableBeanFactory {

    BeanDefinition getBeanDefinitionByName(String name);
}
