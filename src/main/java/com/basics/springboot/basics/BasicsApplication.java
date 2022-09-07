package com.basics.springboot.basics;

import com.basics.springboot.basics.bean.MyBeanWithProperties;
import com.basics.springboot.basics.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BasicsApplication implements CommandLineRunner {
private ComponentDependency componentDependency;
private MyBeanWithProperties myBeanWithProperties;

public BasicsApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
						 MyBeanWithProperties myBeanWithProperties
						 ){
	this.componentDependency = componentDependency;
	this.myBeanWithProperties = myBeanWithProperties;
}
	public static void main(String[] args) {
		SpringApplication.run(BasicsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
componentDependency.hello();
		System.out.println(myBeanWithProperties.function());
	}
}
