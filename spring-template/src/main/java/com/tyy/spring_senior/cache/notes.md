# Spring缓存
Spring缓存可以在@Service和@Controller层调用，避免重复调用@Repository查询数据库

## Spring缓存机制需要依赖具体实现：
* EhCache
* Guava等


## @Cacheable

### 属性
* value: 缓存区名称，不能为空
* key：缓存key，SpEL表达式，如 key="#name"
* condition: 缓存条件， SpEL， 如 condition="#id>100"
* unless： 不缓存条件, SpEL 

### 用法说明
* 类级级的缓存：
@Cacheable 用于类
* 方法级的缓存：
@Cacheable用于方法

注意：只要参数列表一致，即使方法不同，都会返回缓存数据（如果要避免这种状况，可以使用方法级缓存并使用不同缓存区）


## @CacheEvict

### 属性
* value: 指定清除的缓存区 
* allEntries: false or true, 是否清空缓存区
* beforeInvocation:  false or true, 是否在方法调用前执行清除操作
* condition: 清除条件, SpEL
* key: 判断的key组合，默认方法全部参数, SpEL


## 更多讨论
1. Spring Cache 基于 Spring AOP， 对应的Aspect的接口为：
即当给此服务添加缓存注解后,调用者实际拥有的是被调用者的代理引用.当调用代理的方法时,代理可以整体控制实际的方法的入参和返回值.
比如缓存结果,直接跳过执行实际的方法等.

2. 如果缓存需要根据类名和方法名，怎么配置？
@Cacheable(value="articleCache",key="#root.targetClass + #root.methodName")

具体原理有待探究：
注意 org.springframework.cache.interceptor.CacheInterceptor


## 代码说明
beans_EhCache.xml 配置了EhCache作为Spring cache机制的实现类
beans_SimpleCacheManager.xml 利用Spring自己的SimpleCacheManager作为缓存管理器（不推荐实际项目使用）

ClassLevelEhCacheTest.java
MethodLevelEhCacheTest.java
分别为 类级别 和 方法级别 的缓存测试


## 参考文档：
张开涛的博客：http://jinnianshilongnian.iteye.com/blog/2001040








复习：
数据库的隔离级别：
未提交读
已提交读（默认策略）
可重复读
可序列化
