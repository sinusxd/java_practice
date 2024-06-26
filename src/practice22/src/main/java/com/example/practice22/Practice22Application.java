package com.example.practice22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@EnableScheduling
@SpringBootApplication
public class Practice22Application {

	public static void main(String[] args) {
		SpringApplication.run(Practice22Application.class, args);
	}

}
