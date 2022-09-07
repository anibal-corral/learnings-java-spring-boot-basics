package com.basics.springboot.basics.configuration;

import com.basics.springboot.basics.bean.MyBeanWithProperties;
import com.basics.springboot.basics.bean.MyBeanWithPropertiesImplement;
import com.basics.springboot.basics.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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


}
