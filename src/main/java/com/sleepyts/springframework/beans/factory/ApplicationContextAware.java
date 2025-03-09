package com.sleepyts.springframework.beans.factory;

import com.sleepyts.springframework.context.ApplicationContext;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext);
}
