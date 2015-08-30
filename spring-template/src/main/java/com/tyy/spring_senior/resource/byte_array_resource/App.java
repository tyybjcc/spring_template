package com.tyy.spring_senior.resource.byte_array_resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

import org.springframework.core.io.ByteArrayResource;

public class App {
	public static void main(String[] args) throws IOException {
		String s ="Spring 开发";
		byte[] bytes = s.getBytes();
		
		//以关键字母命名变量 有利于 通过IDE 智能查找 类名
		ByteArrayResource bar = new ByteArrayResource(bytes);
		System.out.println(bar.getDescription());
		
		InputStream is = bar.getInputStream();
		byte[] readBytes = new byte[10];
		int count = is.read(readBytes);
		System.out.println( Arrays.toString(readBytes) );
		System.out.println( new String(readBytes) );	//output:Spring 开? 是因为inputStream没有读完
	}
}
