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

	/**
	 * Adding data to database for testing purposes(questions and answers)
	 */
	@Bean
	public void addData() {
		qaRepository.save(new QA(null, "I love you", "ok", "love", "LOVE"));
		qaRepository.save(new QA(null, "What's up dawg", "Nothing much, what's up with you", "Greeting", "GREETING"));
		qaRepository.save(new QA(null, "hi", "Hello", "Greeting", "GREETING"));
	}
}
