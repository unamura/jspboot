package com.example.injection.exper;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ExperApp {
	
	public static void main(String[] args) {
		//SpringApplication.run(ExperApp.class, args);
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ExperApp.class);
		
		ExperRepository er = ctx.getBean(ExperRepository.class);
		
		System.out.println("ExperRepo first print: " + er.printOccupation());
		
		System.out.println("\nExperRepo list print:\n" + er.printListExpert());
		
		System.out.println("\nExperRepo translator list print:\n" + er.printAllTranslator());
		
		System.out.println("\nEditor: " + er.printOneEditor());
		
		((ConfigurableApplicationContext) ctx).close();
	}
}
