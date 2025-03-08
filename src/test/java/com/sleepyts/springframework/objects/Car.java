package com.sleepyts.springframework.objects;

import com.sleepyts.springframework.beans.factory.DestroyBean;
import com.sleepyts.springframework.beans.factory.InitializingBean;

/**
 * @author derekyi
 * @date 2020/11/24
 */
public class Car implements InitializingBean, DestroyBean {

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

	@Override
	public void afterPropertiesSet() {
		System.out.println("Init...");
	}

	@Override
	public void destroy() {
		System.out.println("Destring...");
	}
}
