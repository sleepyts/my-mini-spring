package com.sleepyts.springframework.aop;

public interface PointCut {

    MethodMatcher getMethodMatcher();

    ClassFilter getClassFilter();
}
