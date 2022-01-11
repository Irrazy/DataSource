package com.lzy.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: druid-demo1
 * @description: DruidConfig
 * @author: 作者
 * @create: 2021-12-31 16:24
 */
@Configuration

public class DruidConfig {

    /**设置多数据源时这一段去掉
     * @ConfigurationProperties(prefix = "spring.datasource.druid")  //@ConfigurationProperties: 前缀, 表示带这些前缀的配置生效
     *     @Bean(destroyMethod = "",initMethod = "")
     *     public DataSource druidDataSource(){
     *         return new DruidDataSource();
     *     }
     */


    /**
     * 配置Druid监控--管理后台的Servlet
     *
     * @param :
     * @return: org.springframework.boot.web.servlet.ServletRegistrationBean
     */

    @Bean
    public ServletRegistrationBean statViewServlet() {
        // 注册服务
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");

        Map<String, String> initParams = new HashMap<>();

        //   账号,
        initParams.put("loginUsername", "admin");
        // 密码,
        initParams.put("loginPassword", "123456");
        // 允许登录的ip(为空 就是所有都允许)
        initParams.put("allow", "");
        // 然后是不允许的ip地址
        initParams.put("deny", "192.123.11.11");
        // 是否能够重置数据
        initParams.put("resetEnable", "false");
        // 设置初始化参数
        bean.setInitParameters(initParams);
        return bean;
    }


    /**
     * 配置web监控的filter
     *
     * @param :
     * @return: org.springframework.boot.web.servlet.FilterRegistrationBean
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        // 添加过滤规则
        Map<String, String> initParams = new HashMap<>();
        // 不拦截那些属性
        initParams.put("exclusions","*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*");
        // 设置初始化参数
        bean.setInitParameters(initParams);
        // 默认拦截所有
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}

