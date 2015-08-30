# Spring高级

## 1. 后处理器 PostProcessor
Spring提供两种后处理器：
* Bean后处理器
* 容器后处理器

### 1.1 Bean后处理器
对Bean进行后处理与增强，实现BeanPostProcessor接口

```java
public interface BeanPostProcessor {
	Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;
	Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
```

示例：
```java
public class MyBeanPostProcessor
	implements BeanPostProcessor
{
	/**
	 * 对容器中的Bean实例进行后处理
	 * @param bean 需要进行后处理的原Bean实例
	 * @param beanName 需要进行后处理的Bean的配置id
	 * @return 返回后处理完成后的Bean
	 */
	public Object postProcessBeforeInitialization
		(Object bean , String beanName)
	{
		System.out.println("Bean后处理器在初始化之前对"
			+ beanName + "进行增强处理...");
		// 返回的处理后的Bean实例，该实例就是容器中实际使用的Bean
		// 该Bean实例甚至可与原Bean截然不同
		return bean;
	}
	public Object postProcessAfterInitialization
		(Object bean , String beanName)
	{
		System.out.println("Bean后处理器在初始化之后对"
			+ beanName + "进行增强处理...");
		// 如果该Bean是Chinese类的实例
		if (bean instanceof Chinese)
		{
			// 修改其name成员变量
			Chinese c = (Chinese)bean;
			c.setName("疯狂iOS讲义");
		}
		return bean;
	}
}
```

对应的XML配置
```XML
<!-- 配置Bean后处理器，可以无需指定id属性 -->
<bean id="bp" class="org.crazyit.app.util.MyBeanPostProcessor"/>
```

#### Bean后处理器的用途：生成Proxy等，Spring提供的两个BeanPostProcessor：
* BeanNameAutoProxyCreator: 根据Bean实例的name属性创建Bean实例的代理（name属性配置Bean别名）
* DefaultAdvisorAutoProxyCreator: 根据提供的Advisor，对容器中Bean实例创建代理，实现filter功能


### 1.2 容器后处理器
处理容器本身，实现BeanFactoryPostProcessor

```java
public interface BeanFactoryPostProcessor {
	void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;

}
```

实现代码：
```java
public class MyBeanFactoryPostProcessor
	implements BeanFactoryPostProcessor
{
	/**
	 * 重写该方法，对Spring进行后处理。
	 * @param beanFactory Spring容器本身
	 */
	public void postProcessBeanFactory(
		ConfigurableListableBeanFactory beanFactory)
		throws BeansException
	{
		System.out.println("程序对Spring所做的BeanFactory的初始化没有改变...");
		System.out.println("Spring容器是：" + beanFactory);
	}
}
```

对应的XML文件
```XML
<bean id="beanFactoryPostProcessor"  class="org.crazyit.app.util.MyBeanFactoryPostProcessor"/>
```

#### 用法
Spring容器本身提供的几个容器后处理器：
PropertyPlaceholderConfigurer: 读取.properties配置文件信息
PropertyOverrideConfigurer: .properties配置文件信息覆盖XML配置文件信息
CustomAutowireConfigurer
CustomScopeConfigurer

#### PropertyPlaceholderConfigurer的使用

```XML
<bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<list>
				<value>dbconn.properties</value>
				<!-- 如果有多个属性文件,依次在下面列出来 -->
				<!--value>wawa.properties</value-->
			</list>
		</property>
</bean>
<!-- 定义数据源Bean，使用C3P0数据源实现 -->
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
	destroy-method="close"
	p:driverClass="${jdbc.driverClassName}"
	p:jdbcUrl="${jdbc.url}"
	p:user="${jdbc.username}"
	p:password="${jdbc.password}"/>
```


需要dbconn.properties文件，内容如下：

```properties
jdbc.driverClassName=com.mysql.jdbc.Driver
jdbc.url=jdbc:mysql://localhost:3306/spring
jdbc.username=root
jdbc.password=32147
```

XML文件的简化配置
```XML
<context:property-placeholder location="dbconn.properties" />
```

#### PropertyOverrideConfigurer的用法

```XML
<!-- PropertyOverrideConfigurer是一个容器后处理器，它会读取属性文件信息，并用这些信息设置覆盖Spring配置文件的数据 -->
<bean class= "org.springframework.beans.factory.config.PropertyOverrideConfigurer">
	<property name="locations">
		<list>
			<value>dbconn.properties</value>
		</list>
	</property>
</bean>
<!-- 不用配置属性信息，这些信息在properties文件中出现 -->
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"  destroy-method="close"/>
```

dbconn.properties文件和前面一样。


## 2. Spring“零配置”支持

### 2.1 Bean注解及搜索

Spring提供以下注解：

	@Controller	控制器组件
	@Service	业务逻辑组件
	@Repository	Dao组件
	@Component	一般Bean

组件的搜索配置
```XML
<context:component-scan base-package="org.crazyit.app.service"/>
```

可以使用include-filter和exclude-filter
```XML
<context:component-scan base-package="org.crazyit.app.service">
	<!-- 只将以Chinese、Axe结尾的类当成Spring容器中的Bean -->
	<context:include-filter type="regex" expression=".*Chinese"/>
	<context:include-filter type="regex" expression=".*Axe"/>
</context:component-scan>
	```

	
