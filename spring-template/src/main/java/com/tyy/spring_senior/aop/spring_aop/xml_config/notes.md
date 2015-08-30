XML配置的优点：
* 清晰，通过配置文件可以看到系统中所有AOP配置信息

缺点：
* 不利于查看（配置分散杂乱）
* 仅支持singleton的切面Bean，不能在XML中组合 多个命名连接点的声明
* 不利于迁移（Spring采用了AspectJ支持的注解）

注意：
采用<aop:config.../>方式手动配置 和 采用 <aop:aspect-autoproxy/>



配置：

pointcut：

```XML
<aop:pointcut id="myPointcut" expression="execution(* *(..))" />

```

