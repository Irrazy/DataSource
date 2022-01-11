package com.lzy.config;

/**
 * @program: tk-druid-aop
 * @description: 动态数据源切换控制
 * @author: 作者
 * @create: 2022-01-07 11:45
 */
public class DynamicDataSourceContextHolder {
    //定义两个数据源的放在dbs Map中的key值
    public static final String DBS1_KEY="db1";
    public static final String DBS2_KEY="db2";


    /**
     * ThreadLocal 是线程的局部变量， 是每一个线程所单独持有的，其他线程不能对其进行访问，
     * 通常是类中的 private static 字段，是对该字段初始值的一个拷贝
     * ###########################################
     * 当使用ThreadLocal维护变量的时候 为每一个使用该变量的线程提供一个独立的变量副本，
     * 即每个线程内部都会有一个该变量，这样同时多个线程访问该变量并不会彼此相互影响，
     * 因此他们使用的都是自己从内存中拷贝过来的变量的副本， 这样就不存在线程安全问题，也不会影响程序的执行性能。
     * ##############ThreadLocal 方法使用详解##################
     * public T get() { }          // 用来获取ThreadLocal在当前线程中保存的变量副本
     * public void set(T value) { }              //set()用来设置当前线程中变量的副本
     * public void remove() { }             //remove()用来移除当前线程中变量的副本
     * protected T initialValue() { }         //initialValue()是一个protected方法，一般是用来在使用时进行重写的
     */

    //定义 一个线程局部变量：动态数据源名称，每个线程互不影响----核心
    private static final ThreadLocal<String> DATASOURCE_CONTEXT_KEY = new ThreadLocal<>();

    //设置（切换）数据源
    public static void setContextKey(String key){
        DATASOURCE_CONTEXT_KEY.set(key);
    }

    //获取数据源名称
    public static String getContextKey(){
        String key = DATASOURCE_CONTEXT_KEY.get();
        //如果没有设置哪个数据源名称，默认数据源1
        return key == null ? DBS1_KEY : key;
    }

    //删除当前数据源名称
    public static void removeContextKey(){
        DATASOURCE_CONTEXT_KEY.remove();
    }


}
