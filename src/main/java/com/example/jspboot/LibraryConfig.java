package com.example.jspboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {

	@Bean
	public Book getBook() {
		return new Book();
	}
	
	@Bean
	public BookRepository getBookRepository() {
		return new BookRepository();
	}
}
