package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;

public interface BeanInstantiationStrategy {
    Object instance(BeanDefinition beanDefinition);
}
