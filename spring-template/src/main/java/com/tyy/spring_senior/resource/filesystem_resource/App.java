package com.tyy.spring_senior.resource.filesystem_resource;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

public class App {
	/**
	 * 不常用，可使用File类
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		FileSystemResource fsRes = new FileSystemResource("src/main/java/com/tyy/spring_senior/resource/url_resource/student.xml");	//相对路径，相对于应用根目录
		System.out.println( fsRes.getFile().getAbsolutePath() );
		System.out.println(fsRes.getDescription());
		
	}
}
