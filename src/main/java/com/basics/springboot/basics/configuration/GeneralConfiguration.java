package com.basics.springboot.basics.configuration;

import com.basics.springboot.basics.bean.MyBeanWithProperties;
import com.basics.springboot.basics.bean.MyBeanWithPropertiesImplement;
import com.basics.springboot.basics.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.firstname}")
    private String firstname;
    @Value("${value.lastname}")
    private String lastname;
    @Value("${value.random}")
    private String random;

    @Bean
    public MyBeanWithProperties function(){
        return new MyBeanWithPropertiesImplement(firstname, lastname);
    }

@Bean
    public DataSource h2Source()
{
    DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    dataSourceBuilder.driverClassName("org.h2.Driver");
    dataSourceBuilder.url("jdbc:h2:mem:aecsdb");
    dataSourceBuilder.username("SA");
    dataSourceBuilder.password("");
    return dataSourceBuilder.build();
}
}
