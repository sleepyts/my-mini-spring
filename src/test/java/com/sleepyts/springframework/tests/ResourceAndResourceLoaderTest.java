package com.sleepyts.springframework.tests;

import cn.hutool.core.io.IoUtil;
import com.sleepyts.springframework.beans.core.io.DefaultResourceLoader;
import com.sleepyts.springframework.beans.core.io.Resource;
import org.junit.Test;

import java.io.InputStream;

public class ResourceAndResourceLoaderTest {

	@Test
	public void testResourceLoader() throws Exception {
		DefaultResourceLoader resourceLoader = new DefaultResourceLoader();

		//加载classpath下的资源
		Resource resource = resourceLoader.getResource("classpath:hello.txt");
		InputStream inputStream = resource.getInputStream();
		String content = IoUtil.readUtf8(inputStream);
		System.out.println(content);

		//加载文件系统资源
		resource = resourceLoader.getResource("src/test/resources/hello.txt");
		inputStream = resource.getInputStream();
		content = IoUtil.readUtf8(inputStream);
		System.out.println(content);

		//加载url资源
		resource = resourceLoader.getResource("https://www.baidu.com");
		inputStream = resource.getInputStream();
		content = IoUtil.readUtf8(inputStream);
		System.out.println(content);
	}
}