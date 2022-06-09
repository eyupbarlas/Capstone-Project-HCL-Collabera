package io.capstone.website_service;

import io.capstone.website_service.entity.QA;
import io.capstone.website_service.repository.QARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebsiteServiceApplication {
	@Autowired
	private QARepository qaRepository;

	public static void main(String[] args) {
		SpringApplication.run(WebsiteServiceApplication.class, args);
	}

	@Bean
	public void addData() {
		qaRepository.save(new QA(null, "Campus Size", "1200acres", "Campus", "CAMPUS"));
		qaRepository.save(new QA(null, "Campus Color", "Green", "Campus", "CAMPUS"));
		qaRepository.save(new QA(null, "Number of Departments", "10", "Department", "DEPARTMENTS"));
		qaRepository.save(new QA(null, "Male Female Ratio", "50:50", "Ratio", "FUN"));
		qaRepository.save(new QA(null, "hi", "Hello", "Greeting", "GREETING"));
	}
}
