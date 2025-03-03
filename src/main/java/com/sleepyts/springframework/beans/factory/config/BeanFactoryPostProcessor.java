package com.sleepyts.springframework.beans.factory.config;


public interface BeanFactoryPostProcessor {

    /**
     * 在所有BeanDefinition加载完成后，但在bean实例化之前，提供修改BeanDefinition属性值的机制
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory);

}
