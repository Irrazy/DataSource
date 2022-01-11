本demo是基于tk-mybatis+druid多数据源dynamic动态切换+分页+swagger3

1.使用pagehelper时，要将springboot的pom依赖版本回退到2.5.7，否则会发生pagehelper的循环依赖
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.5.7</version>
        <relativePath/> <!-- lookup parent from repository -->
    </parent>
2.@DS注解
  @DS注解可用于方法或类上。若同时存在，则方法上的注解优先于类上的注解。
  官网推荐@DS注解在service层使用，且是实现类上使用，在接口层无效。注解用在service实现或mapper接口方法上，不要同时在service和mapper注解。

  若没有使用@DS注解，则会使用默认数据源。
  @DS(“dsName”) dsName可以为某个具体库名，也可以为组名。若dsName为组名，则会使用负载均衡算法进行切换。

3.报错：Skipping MapperFactoryBean with name 'bookMapper' and 'com.lzy.mapper.BookMapper' mapperInterface. Bean already defined with the same name!
即--重复注入mapper的bean对象，去掉BookMapper的@Mapper注解,但是要注意启动类上的@MapperScan()注解要用tk包中的注解

4.swgger访问用EelementUI包装过的，http://localhost:8989/doc.html