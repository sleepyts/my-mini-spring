package com.sleepyts.springframework.objects;

import com.sleepyts.springframework.beans.factory.*;
import com.sleepyts.springframework.context.ApplicationContext;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class Car {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                '}';
    }
}
