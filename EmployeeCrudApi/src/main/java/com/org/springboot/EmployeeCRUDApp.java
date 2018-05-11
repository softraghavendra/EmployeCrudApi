package com.org.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class EmployeeCRUDApp {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeCRUDApp.class, args);

	}

}
