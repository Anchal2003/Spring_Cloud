package com.spring.jdbc;

import com.spring.jdbc.model.Alien;
import com.spring.jdbc.repo.AlienRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbCdemoApplication {

	public static void main(String[] args) {
		ApplicationContext  context=SpringApplication.run(SpringJdbCdemoApplication.class, args);

		Alien alien1 = context.getBean(Alien.class);
		alien1.setId(105);
		alien1.setName("Anchal");
		alien1.setTech("Java");


		AlienRepo repo = context.getBean(AlienRepo.class);
		repo.save(alien1);

		System.out.println(repo.findAll());

	}

}
