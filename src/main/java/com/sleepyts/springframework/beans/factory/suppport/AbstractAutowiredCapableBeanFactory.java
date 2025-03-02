package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.PropertyValue;
import com.sleepyts.springframework.beans.factory.PropertyValues;
import com.sleepyts.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import com.sleepyts.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Field;

public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    BeanInstantiationStrategy beanInstantiationStrategy=new SimpleBeanInstantiationStrategy();
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = doInstanceBean(beanDefinition);
            doAddPropertyValues(bean,beanDefinition,beanName);
        } catch (Exception e) {

        }
        registerSingleton(beanName,bean);
        return bean;
    }

    private Object doInstanceBean(BeanDefinition beanDefinition){
        return beanInstantiationStrategy.instance(beanDefinition);
    }

    private void doAddPropertyValues(Object bean,BeanDefinition beanDefinition,String beanName){
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for(PropertyValue propertyValue:propertyValues.getPropertyValues()){
            String argName = propertyValue.getName();
            Object argValue= propertyValue.getValue();

            try {
                // 简单解决bean的依赖关系
                //todo 解决循环依赖问题
                if (argValue instanceof BeanReference beanReference){
                    argValue=getBean(beanReference.getBeanName());
                }
                Field arg = bean.getClass().getDeclaredField(argName);
                arg.setAccessible(true);
                arg.set(bean,argValue);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
