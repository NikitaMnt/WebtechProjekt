package com.example.webtech1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan
@SpringBootApplication
public class Webtech1Application {

	public static void main(String[] args) {
		SpringApplication.run(Webtech1Application.class, args);
	}

}
