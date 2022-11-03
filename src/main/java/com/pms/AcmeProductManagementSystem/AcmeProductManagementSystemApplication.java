package com.pms.AcmeProductManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages="com.pms")
@EnableJpaRepositories(basePackages="com.pms")
@EntityScan(basePackages="com.pms")
public class AcmeProductManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(AcmeProductManagementSystemApplication.class, args);
	}

}
