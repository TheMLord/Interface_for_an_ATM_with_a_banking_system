package com.example.ATMMachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan
@EnableJpaRepositories
public class AtmMachineApplication {
	public static void main(String[] args) {
		SpringApplication.run(AtmMachineApplication.class, args);
	}

}
