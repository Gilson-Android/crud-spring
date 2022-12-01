package com.gilson.crudspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.gilson.crudspring.model.Course;
import com.repository.CourseRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages =  "com.repository")
public class CrudSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudSpringApplication.class, args);
	}

	@Bean
    CommandLineRunner initDataBase(CourseRepository courseRepository){

            courseRepository.deleteAll();

			Course c = new Course();
			c.setName("Angular com Spring");
			c.setCategory("front-end");

            courseRepository.save(c);
        
			return null;
    }
}
