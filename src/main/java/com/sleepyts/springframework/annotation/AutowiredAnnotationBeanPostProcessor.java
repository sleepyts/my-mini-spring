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
            Value value = declaredField.getAnnotation(Value.class);
            if (value != null && !value.value().isEmpty()) {
                String valueStr = value.value();
                declaredField.setAccessible(true);
                try {
                    if (declaredField.getType() == String.class)
                        declaredField.set(bean, valueStr);
                    else if (declaredField.getType() == int.class || declaredField.getType() == Integer.class)
                        declaredField.set(bean, Integer.parseInt(valueStr));
                    else if (declaredField.getType() == long.class || declaredField.getType() == Long.class)
                        declaredField.set(bean, Long.parseLong(valueStr));
                    else if (declaredField.getType() == double.class || declaredField.getType() == Double.class)
                        declaredField.set(bean, Double.parseDouble(valueStr));
                    else if (declaredField.getType() == float.class || declaredField.getType() == Float.class)
                        declaredField.set(bean, Float.parseFloat(valueStr));
                    else if (declaredField.getType() == boolean.class || declaredField.getType() == Boolean.class)
                        declaredField.set(bean, Boolean.parseBoolean(valueStr));
                } catch (IllegalAccessException e) {

                }
            }
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
}
