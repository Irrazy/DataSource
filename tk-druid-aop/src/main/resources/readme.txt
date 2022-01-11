本demo基于tkmybatis+druid多数据源aop动态切换---注解式

步骤整理：
1.针对yml中的多数据源写法--dbs:db1---db2,写一个dbsConfig----dbs配置类
  定义私有化map集合dbs，类型为<key:String(数据源名称)  ,value: DruidDataSource（druid数据源>-----（这个就类似于定义枚举类）
  定义这个类为配置类，给配置类属性--前缀prefix:yml中数据源配置前缀-----这样直接将db1,db2两个数据源注入这个map里

2.写一个DynamicDataSourceConfig----动态数据源配置类
  这个类主要写一个返回动态数据源的方法：
    创建一个数据源集合dataSourceMap，获取dbsConfig中注入的dbs集合并遍历输入到之前创建的数据源集合dataSourceMap；
    实例化一个 动态数据源DynamicDataSource，调用设置目标数据源方法，参数是数据源集合dataSourceMap；
                                         调用设置默认数据源方法，参数为dbsConfig中注入的dbs集合里的某一个数据源

3.创建数据源切换类class DynamicDataSourceContextHolder------就是一个中间类
  这个类主要是控制动态数据源名称key切换---线程互不影响
     创建一个线程局部变量ThreadLocal：动态数据源名称 ，利用set()、get()、remove()方法对数据源名称切换

4.创建一个动态数据源类，继承抽象路由数据源类class DynamicDataSource extends AbstractRoutingDataSource
  这个类主要是重写determineCurrentLookupKey()方法，返回当前被设置/使用的数据源名称key值
     利用数据源切换类中的get（）方法

5.创建数据源注解@DataSource

6.创建切面类DataSourceAspect，根据@DataSource注解类创建切入点，切换数据源















学习链接：https://blog.csdn.net/qq_34869990/article/details/113759048?ops_request_misc=&request_id=&biz_id=102&utm_term=%E9%80%9A%E7%94%A8mapper%E5%A4%9A%E6%95%B0%E6%8D%AE%E6%BA%90aop%E5%88%87%E6%8D%A2&utm_medium=distribute.pc_search_result.none-task-blog-2~all~sobaiduweb~default-1-113759048.first_rank_v2_pc_rank_v29&spm=1018.2226.3001.4187