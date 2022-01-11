1.此demo是在springboot集成ybatis-plus代码生成器的基础上(即本地文件夹中的mp-auto-demo1文件)，
  结合druid配置单数据源
2.添加swagger接口文档maven依赖
  swagger3.0版本依赖和springboot2.6.2版本冲突，会报错无法启动文档，空指针异常，将springboot版本降级至2.5.7即可

3.访问E-UI包装过后的swagger文档 http://localhost:8989/doc.html