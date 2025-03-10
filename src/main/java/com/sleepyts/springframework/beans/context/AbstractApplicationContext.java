package com.sleepyts.springframework.beans.context;

import com.sleepyts.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.sleepyts.springframework.beans.factory.config.BeanPostProcessor;
import com.sleepyts.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Map;

public abstract class AbstractApplicationContext implements ConfigurableApplicationContext {

    @Override
    public void refresh() {
        refreshBeanFactory();
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        invokeBeanFactoryProcessors(beanFactory);

        registerBeanPostProcessors(beanFactory);

    }

    protected abstract void refreshBeanFactory();


    private void invokeBeanFactoryProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> processors = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor postProcessor : processors.values()) {
            postProcessor.postProcessBeanFactory(beanFactory);
        }
    }

    private void registerBeanPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> processorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor processor : processorMap.values()) {
            beanFactory.addBeanPostProcessor(processor);
        }
    }

    protected abstract ConfigurableListableBeanFactory getBeanFactory();
}
