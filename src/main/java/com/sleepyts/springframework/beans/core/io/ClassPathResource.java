package com.sleepyts.springframework.beans.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


/**
 * 类路径资源访问
 */
public class ClassPathResource implements Resource {

    private final String resourcePath;

    public ClassPathResource(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(resourcePath);
        if (resourceAsStream == null) {
            throw new FileNotFoundException(this.resourcePath +" can't be opened cause it doesn't exist");
        }
        return resourceAsStream;
    }
}
