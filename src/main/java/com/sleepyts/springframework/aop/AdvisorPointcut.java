package com.sleepyts.springframework.aop;


public interface AdvisorPointcut extends Advisor {

    PointCut getPointcut();
}
