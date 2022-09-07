package com.basics.springboot.basics;

import com.basics.springboot.basics.bean.MyBeanWithProperties;
import com.basics.springboot.basics.component.ComponentDependency;
import com.basics.springboot.basics.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicsApplication implements CommandLineRunner {
	Log LOGGER = LogFactory.getLog(BasicsApplication.class);
private ComponentDependency componentDependency;
private MyBeanWithProperties myBeanWithProperties;
private UserPojo userPojo;

public BasicsApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
						 MyBeanWithProperties myBeanWithProperties,
						 UserPojo userPojo
						 ){
	this.componentDependency = componentDependency;
	this.myBeanWithProperties = myBeanWithProperties;
	this.userPojo=userPojo;
}
	public static void main(String[] args) {
		SpringApplication.run(BasicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
componentDependency.hello();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail() + " " + userPojo.getPassword() + " " + userPojo.getAge());
		LOGGER.error("This is an error");
	}
}
