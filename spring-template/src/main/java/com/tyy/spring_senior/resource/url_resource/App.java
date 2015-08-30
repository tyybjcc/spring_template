package com.tyy.spring_senior.resource.url_resource;

import java.io.File;
import java.io.Reader;
import java.net.MalformedURLException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.core.io.UrlResource;

public class App {

	public static void main(String[] args) throws Exception {
		UrlResource urlRes = new UrlResource("file:src/main/java/com/tyy/spring_senior/resource/url_resource/student.xml");	//没有以/开头使用的是相对路径
		System.out.println(urlRes.getFilename());
		//Dom4J SAX parsing
		SAXReader saxReader = new SAXReader();
		Document doc = saxReader.read(urlRes.getInputStream());	//or getFile()
		Element ele = doc.getRootElement();
		List list = ele.elements();
		for(Object obj : list) {
			Element ele2 = (Element)obj;
			System.out.print( ele2.getName() +": ");
			System.out.print( ele2.attributeValue("id") + " " );
			System.out.println( ele2.getStringValue() );
		}
		
		/**
		 * 还可以使用
		 * http:
		 * ftp:
		 * 访问HTTP协议、FTP协议的资源
		 * 
		 * UrlResource是对java.net.URL的封装
		 */
		
		
		
		
	}
}
