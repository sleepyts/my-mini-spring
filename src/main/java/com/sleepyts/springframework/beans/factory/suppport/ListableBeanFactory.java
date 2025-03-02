package com.sleepyts.springframework.beans.factory.suppport;

import com.sleepyts.springframework.beans.factory.BeanFactory;

import java.util.Map;

public interface ListableBeanFactory extends BeanFactory {

    /**
     * 获取某一类型的所有Bean
     *
     * @param type
     * @param <T>
     * @return
     */
    <T> Map<String, T> getBeansOfType(Class<T> type);

    String[] getAllBeanDefinitionNames();
}
