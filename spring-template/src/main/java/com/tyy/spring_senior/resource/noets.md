* Spring可以根据

	file: 
	http: 
	classpath: 
	
判断要使用的Resource实现类； 


* 如果没有前缀，则根据ApplicationContext实现类判定:

	ClassPathXmlApplicationContext -> ClassPathResource
	FileSystemXmlApplicationContext -> FileSystemResource
	XmlWebApplicationContext -> ServletContextResource

* 注意：

ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:beans.xml");
将加载 类加载路径中所有的beans.xml配置文件
（仅对ApplicationContext加载配置文件是有效）



* Bean中的Resource注入：

XML配置文件中可以使用p:resVariable="classpath:student.xml" 为 Resource resVariable变量注入资源
(也可以通过<property name="resVariable" value="classpath:student.xml">)


* 注意：

对于FileSystemXMLApplicationContext(String attr)
attr不论是否以/开头，都访问的是相对路径
只有file:/开头才能实现访问绝对路径
