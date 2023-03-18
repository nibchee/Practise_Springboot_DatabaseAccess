package com.geekynib.cruddemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	//Creating Bean this is from Spring Framework executed after beans are loaded
	@Bean
	public CommandLineRunner commandLineRunner(String args[]){
		//Java Lamda Expression
		return  runner->{
			System.out.println("Hello World");
		};
	}

}
