package com.example.jspboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.dao.Movie;
import com.example.dao.Production;

@SpringBootApplication
public class JspApplication {

	public static void main(String[] args) {
		SpringApplication.run(JspApplication.class, args);
		/*
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemConfig.class);
		
		Movie m = ctx.getBean(Movie.class);
		System.out.println("Movie = " + m.toString());
		
		Movie hm = ctx.getBean(Movie.class);
		System.out.println("Movie = " + hm.getHybridRole());
		
		Production ep = ctx.getBean(Production.class);
		System.out.println("Production = " + ep.getTechnician ());
		
		Production ip = ctx.getBean(Production.class);
		System.out.println("Production = " + ip.getExpert ());
		
		((ConfigurableApplicationContext) ctx).close();
		*/
	}

}