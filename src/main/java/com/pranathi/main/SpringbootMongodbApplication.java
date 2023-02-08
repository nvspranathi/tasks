package com.pranathi.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
public class SpringbootMongodbApplication {

	public static void main(String[] args) throws Throwable {
		SpringApplication.run(SpringbootMongodbApplication.class, args);
		
		/*
		Assignee a = new Assignee();
		System.out.println(a.ldt);
		a=null;
		System.gc(); // calls garbage collector immediately
		*/
	}
}
