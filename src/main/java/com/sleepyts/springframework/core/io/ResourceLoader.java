package com.sleepyts.springframework.core.io;


/**
 * 加载资源抽象接口
 */
public interface ResourceLoader {
    Resource getResource(String location);
}
