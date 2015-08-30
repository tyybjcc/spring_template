Spring transaction：

## 分类：
* 全局事务：由应用服务器管理，服务器需要JTA支持，可以横跨多个事务性资源（如数据库、消息队列）
* 局部事务：与底层的持久化技术有关（JDBC的Connection、Hibernate的Session等）

Spring事务通过org.springframework.transaction.PlatformTransactionManager接口统一管理：

```java
package org.springframework.transaction;
public interface PlatformTransactionManager {
	TransactionStatus getTransaction(TransactionDefinition definition) throws TransactionException;	//获取一个新事务
	void commit(TransactionStatus status) throws TransactionException;
	void rollback(TransactionStatus status) throws TransactionException;
}
```

PlatformTransactionManager有多个实现类，由Spring自行判断调用，这是一种“策略模式”。我们配置transactionManager时，其实是要配置该接口的实现类。如：
* JDBC：org.springframework.jdbc.datasource.DataSourceTransactionManager
* JTA: org.springframework.transaction.jta.JtaTransactionManager
* Hibernate: org.springframework.orm.hibernate3.support.HibernateTransactionManager

注意：对于JTA的实现，可能会略有差异，需要使用服务器厂商提供的TransactionManager



## TransactionDefinition定义了事务规则：
* 隔离级别 (ISOLATION_DEFAULT, ISOLATION_READ_UNCOMMITTED, ISOLATION_READ_COMMITTED, ISOLATION_REPEATABLE_READ, ISOLATION_SERIALIZABLE )
* 事务传播(PROPAGATION_REQUIRED, PROPAGATION_SUPPORTS, PROPAGATION_MANDATORY, PROPAGATION_REQUIRES_NEW, PROPAGATION_NOT_SUPPORTED, PROPAGATION_NEVER, PROPAGATION_NESTED)
* 超时
* 只读状态

具体含义参考：
http://blog.csdn.net/hijiankang/article/details/9174461

具体定义参考：
org.springframework.transaction.TransactionDefinition







