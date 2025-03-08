package com.sleepyts.springframework.beans.factory.suppport;

import cn.hutool.core.util.StrUtil;
import com.sleepyts.springframework.beans.factory.DestroyBean;
import com.sleepyts.springframework.beans.factory.InitializingBean;
import com.sleepyts.springframework.beans.factory.PropertyValue;
import com.sleepyts.springframework.beans.factory.PropertyValues;
import com.sleepyts.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.sleepyts.springframework.beans.factory.config.BeanDefinition;
import com.sleepyts.springframework.beans.factory.config.BeanPostProcessor;
import com.sleepyts.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public abstract class AbstractAutowiredCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    BeanInstantiationStrategy beanInstantiationStrategy = new SimpleBeanInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        return doCreateBean(beanName, beanDefinition);
    }

    protected Object doCreateBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = doInstanceBean(beanDefinition);
            doAddPropertyValues(bean, beanDefinition, beanName);
            initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {

        }

        registerDisposableBeanIfNecessary(beanName,bean,beanDefinition);
        registerSingleton(beanName, bean);
        return bean;
    }

    private Object doInstanceBean(BeanDefinition beanDefinition) {
        return beanInstantiationStrategy.instance(beanDefinition);
    }

    private void doAddPropertyValues(Object bean, BeanDefinition beanDefinition, String beanName) {
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
            String argName = propertyValue.getName();
            Object argValue = propertyValue.getValue();

            try {
                // 简单解决bean的依赖关系
                //todo 解决循环依赖问题
                if (argValue instanceof BeanReference beanReference) {
                    argValue = getBean(beanReference.getBeanName());
                }
                Field arg = bean.getClass().getDeclaredField(argName);
                arg.setAccessible(true);
                arg.set(bean, argValue);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }

    protected void initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        bean = applyBeanPostProcessorBeforeInitialization(bean, beanName);

        invokeInitMethods(beanName, bean, beanDefinition);

        bean = applyBeanPostProcessorAfterInitialization(bean, beanName);
    }

    protected Object applyBeanPostProcessorBeforeInitialization(Object existBean, String beanName) {
        List<BeanPostProcessor> beanPostProcessors = this.getBeanPostProcessors();
        Object ret = existBean;
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            Object o = beanPostProcessor.postProcessBeforeInitialization(existBean, beanName);
            if (o == null)
                return ret;
            ret = o;
        }
        return ret;
    }

    protected Object applyBeanPostProcessorAfterInitialization(Object existBean, String beanName) {
        List<BeanPostProcessor> beanPostProcessors = this.getBeanPostProcessors();
        Object ret = existBean;
        for (BeanPostProcessor beanPostProcessor : beanPostProcessors) {
            Object o = beanPostProcessor.postProcessAfterInitialization(existBean, beanName);
            if (o == null)
                return ret;
            ret = o;
        }
        return ret;
    }

    protected void invokeInitMethods(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof InitializingBean initializingBean) {
            initializingBean.afterPropertiesSet();
        }
        String initMethodName = beanDefinition.getInitMethodName();

        if (!initMethodName.isBlank() && !(bean instanceof InitializingBean && "afterPropertiesSet".equals(initMethodName))) {
            try {
                Class<?> beanClass = bean.getClass();
                Method method = beanClass.getMethod(initMethodName);
                method.invoke(bean);
            } catch (Exception e) {

            }

        }

    }

    /**
     * 注册有销毁方法的bean，即bean继承自DisposableBean或有自定义的销毁方法
     *
     * @param beanName
     * @param bean
     * @param beanDefinition
     */
    protected void registerDisposableBeanIfNecessary(String beanName, Object bean, BeanDefinition beanDefinition) {
        if (bean instanceof DestroyBean || StrUtil.isNotEmpty(beanDefinition.getDestroyMethodName())) {
            registerDestroyBean(beanName, new DisposableBeanAdapter(bean, beanName, beanDefinition));
        }
    }
}
