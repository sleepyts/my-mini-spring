package com.sleepyts.springframework.aop;

public interface ClassFilter {

    boolean matches(Class<?> clazz);
}
