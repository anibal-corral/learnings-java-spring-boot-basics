package com.basics.springboot.basics;

import com.basics.springboot.basics.bean.MyBeanWithProperties;
import com.basics.springboot.basics.component.ComponentDependency;
import com.basics.springboot.basics.entity.User;
import com.basics.springboot.basics.pojo.UserPojo;
import com.basics.springboot.basics.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BasicsApplication implements CommandLineRunner {
	Log LOGGER = LogFactory.getLog(BasicsApplication.class);
private ComponentDependency componentDependency;
private MyBeanWithProperties myBeanWithProperties;
private UserPojo userPojo;
private UserRepository userRepository;

public BasicsApplication(@Qualifier("componentImplementTwo") ComponentDependency componentDependency,
						 MyBeanWithProperties myBeanWithProperties,
						 UserPojo userPojo,
						 UserRepository userRepository
						 ){
	this.componentDependency = componentDependency;
	this.myBeanWithProperties = myBeanWithProperties;
	this.userPojo=userPojo;
	this.userRepository=userRepository;
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
		saveUsersInDatabase();
		getInfoWithJpql();
	}

	public void saveUsersInDatabase(){
		User anais = new User("Anastasia", "anastasia.corral.m@gmail.com", LocalDate.of(2018,12,16));
		User daniela = new User("Daniela", "daniela.corral.s@gmail.com", LocalDate.of(1993,5,3));
		List<User> list = Arrays.asList(anais,daniela);

		list.stream().forEach(userRepository::save);

	}
	public void getInfoWithJpql(){
	LOGGER.info("User " + userRepository.findByUserEmail("anastasia.corral.m@gmail.com"));
	userRepository.findAndSort("D", Sort.by("id").ascending()).stream().forEach(user -> LOGGER.info("User => ".concat(user.toString())));
	userRepository.findByNameAndEmail("Anastasia", "anastasia.corral.m@gmail.com").stream().forEach(user -> LOGGER.info("User and mail => ".concat(user.toString())));

	userRepository.findByNameLike("%a%").stream().forEach(user -> LOGGER.info("FIND BY NAME LIKE: " + user.toString()));
		userRepository.findByName("%a%").stream().forEach(user -> LOGGER.info("FIND BY NAME: " + user.toString()));
	}

}
