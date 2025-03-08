package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import com.sleepyts.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DefaultListableBeanFactory extends AbstractAutowiredCapableBeanFactory
        implements BeanDefinitionRegistry, ConfigurableListableBeanFactory {

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

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public BeanDefinition getBeanDefinitionByName(String name) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(name);
        if (beanDefinition == null) {

        }

        return beanDefinition;
    }

    @Override
    public void preInstantiateSingletons() {
        Arrays.stream(getAllBeanDefinitionNames()).forEach(this::getBean);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) {
        Map<String, T> result = new HashMap<>();
        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            Class beanClass = beanDefinition.getBeanClass();
            if (type.isAssignableFrom(beanClass)) {
                T bean = (T) getBean(beanName);
                result.put(beanName, bean);
            }
        });
        return result;
    }

    @Override
    public String[] getAllBeanDefinitionNames() {
        Set<String> names = beanDefinitionMap.keySet();
        return names.toArray(new String[names.size()]);
    }
}
