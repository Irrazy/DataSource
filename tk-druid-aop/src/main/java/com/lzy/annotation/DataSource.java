package com.lzy.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD}) //注释起作用的位置，此处表示它只能给类、方法注解
@Retention(RetentionPolicy.RUNTIME)//保留的环境
@Documented //在自定义注解的时候可以使用@Documented来进行标注，如果使用@Documented标注了，在生成javadoc的时候就会把@Documented注解给显示出来。
public @interface DataSource {
    //定义一个注解
    String value();
}
