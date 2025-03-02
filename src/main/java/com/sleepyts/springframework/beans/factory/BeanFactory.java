package com.sleepyts.springframework.beans.factory;

import java.util.HashMap;
import java.util.Map;


public interface BeanFactory {

    Object getBean(String name);

    <T> T getBean(String name, Class<T> type);
}
