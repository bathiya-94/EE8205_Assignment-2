package com.ruhuna.efac.mobilephonesapi;

import com.ruhuna.efac.mobilephonesapi.db.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class MobilePhonesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MobilePhonesApiApplication.class, args);
	}

}
