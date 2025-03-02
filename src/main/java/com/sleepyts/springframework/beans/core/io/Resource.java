package com.sleepyts.springframework.beans.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 资源抽象访问接口
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
