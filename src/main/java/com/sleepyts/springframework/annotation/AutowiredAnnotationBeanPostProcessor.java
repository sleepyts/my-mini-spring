package com.sleepyts.springframework.annotation;

import com.sleepyts.springframework.beans.factory.BeanFactory;
import com.sleepyts.springframework.beans.factory.BeanFactoryAware;
import com.sleepyts.springframework.beans.factory.PropertyValues;
import com.sleepyts.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import com.sleepyts.springframework.beans.factory.suppport.DefaultListableBeanFactory;

import java.lang.reflect.Field;

@Component
public class AutowiredAnnotationBeanPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryAware {

    private DefaultListableBeanFactory beanFactory;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = (DefaultListableBeanFactory) beanFactory;
    }

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) {
        Class<?> beanClass = bean.getClass();
        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Autowired autowired = declaredField.getAnnotation(Autowired.class);
            Qualifier qualifier = declaredField.getAnnotation(Qualifier.class);
            if (autowired != null) {
                Class<?> type = declaredField.getType();
                Object injectedBean = null;
                if (qualifier != null) {
                    injectedBean = beanFactory.getBean(qualifier.value(), type);
                } else
                    injectedBean = beanFactory.getBean(type);
                declaredField.setAccessible(true);
                try {
                    declaredField.set(bean, injectedBean);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return pvs;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return null;
    }
}
