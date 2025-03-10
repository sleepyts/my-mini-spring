package com.sleepyts.springframework.services;

import com.sleepyts.springframework.context.annotation.Component;
import com.sleepyts.springframework.test.TestAnnotation;

/**
 * @author derekyi
 * @date 2020/12/6
 */
public class WorldServiceImpl implements WorldService {

    @Override
    @TestAnnotation
    public void explode() {
        System.out.println("The Earth is going to explode");
    }
}
