1.此demo是在springboot集成mybatis-plus代码生成器的基础上
(即本地文件夹中的mp-auto-demo1文件)，结合druid配置dynamic多数据源,再结合事务处理

2.再结合上分页等其他插件

3.再结合UUID

4.application-dev.properties：开发环境
  application-test.properties：测试环境
  application-prod.properties：生产环境
  application-qa.properties：QA验证

5. mybatis 3.2.0 以上版本移除其本身的性能分析插件PerformceInterceptor，推荐使用第二种方式(执行SQL分析打印--p6spy性能分析插件)方式。

6.启动排除druid连接池默认自动配置
  A.如果在pom文件中引入druid连接池的依赖为druid-spring-boot-starter，那么需要在应用启动时排除druid默认加载的db配置项。
   原因为：DruidDataSourceAutoConfigure会注入一个DataSourceWrapper，这个数据源包装器会在原生spring.datasource或spring.datasource.druid路径下查找url、username、password等属性。
       动态数据源依赖默认加载的 url、username、password等配置项是在spring.datasource.dynamic路径下，因此需要排除druid属性默认加载，否则程序会报错。
   排除druid属性默认加载的方式有两种，一种是在配置文件中排除，另一种是在项目启动类中排除。
  （1）在配置文件中排除druid属性默认加载，其方法为在配置文件中添加如下内容：
   spring.autoconfigure.exclude=com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAuto
   （2）在项目启动类中排除druid属性默认加载，其方法为在@SpringBootApplication注解中排除DruidDataSourceAutoConfigure.class，如下所示：
      @SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
  B.如果在pom文件中引入druid连接池的依赖为非starter版本的druid依赖
    那么应用程序在启动时不会加载druid默认的db配置项，也就不用考虑如何排除DataSourceWrapper数据源包装器。建议使用这种方式。

7.@DS注解
@DS注解可用于方法或类上。若同时存在，则方法上的注解优先于类上的注解。
官网推荐@DS注解在service层使用，且是实现类上使用，在接口层无效。注解用在service实现或mapper接口方法上，不要同时在service和mapper注解。

若没有使用@DS注解，则会使用默认数据源。
@DS(“dsName”) dsName可以为某个具体库名，也可以为组名。若dsName为组名，则会使用负载均衡算法进行切换。