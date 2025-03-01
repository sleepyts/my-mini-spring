package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

public class DefaultListableBeanFactory extends AbstractAutowiredCapableBeanFactory implements BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);

        if (beanDefinition == null) {

        }

        return beanDefinition;
    }

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }
}
