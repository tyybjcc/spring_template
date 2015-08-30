
## 其他知识点：

### 访问目标对象
设置@Advice方法第一个参数为JointPoint, 如JointPoint jp
	
	获取参数 getArgs()
	获取目标对象 getTarget()
	获取代理对象 getThis()
	获取被增强方法信息 getSignature()

### @Advice优先级

规则：
* 优先级规定：用数字标记，数字越小优先级越高
* 执行前优先级高的最先织入，执行后优先级高的最后织入（也就是收尾）

定义方式(Aspect级别)：
* Aspect类实现org.springframework.core.Ordered接口
* @Order注解Aspect类

注意：
优先级相同的织入顺序随机


### 利用args(arg1,arg2,..)参数描述限定被织入的方法 及 参数快速访问

示例：
```java
@Around("execution(* com.tyy.spring_senior.aop.spring_aop.annotation.service.*.*(..)) &&args(arg0,arg1,..)")
public void fun1(int arg0, String arg1){

}
```
只匹配第一个参数为int，第二个参数为String的目标方法； 同时实现前两个参数的快速访问


### 切入点定义

@Pointcut("execution(* com.tyy.spring_senior.aop.spring_aop.annotation.service.*.*(..))")
public void point1(){}

使用：

@Before(pointcut="ClassName.point1()")


### execution定义规则：

execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern) throws-pattern?)

注意：
返回类型、方法名、方法参数不能生

如：
execution(* *(..))	//匹配所有

注意：
所有字段可以用*来通配.对于param-pattern，*代表匹配某一个参数，而..代表任意参数匹配。特别的，如(*,String,..)代表第二个参数为String的参数匹配模式

#### 其他匹配规则：
* within(package.*)	//在包中
* within(package..*)	//在包及子包中
* this(package.InterfaceName)	//代理是指定类或接口的对象	？
* target(package.InterfaceName)	//目标是指定类或接口的对象
* args(java.io.Seriable,*,String,..)	//参数限定

//Spring AOP 提供的切入点指示器
* bean(beanId)
* bean(beanName)
* bean(*Bean)

### 切入点指示器布尔组合：
支持 && || !





