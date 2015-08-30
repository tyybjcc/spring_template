## AOP: aspect oriented programming

### 下载与安装：

从www.eclipse.org/aspectj/download.php中下载AspectJ jar安装文件，安装好后根据提示设置PATH，CLASSPATH环境变量

编译方法：
1. 首先将java文件编译成字节码文件：
javac *.java 或利用eclipse自动编译
2. ajc -d aspectj文件路径

预期结果：
* 使用java运行MainClass对应的main方法时看到被增强处理的运行结果：
java package.MainClass	得到增强处理的运行结果
* class文件采用jd(java decompiler)看到相应的增强代码

实际结果：没有成功，没有任何变化

思考：是否为java8不支持

// TODO
以后有时间继续测试 