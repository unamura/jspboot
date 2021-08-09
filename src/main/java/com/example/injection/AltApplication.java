package com.example.injection;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
//@ComponentScan({"com.example.injection"})
public class AltApplication {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AltApplication.class);
		
		Program p = ctx.getBean(Program.class);
		System.out.println(" Component: " + p.getJournalist("Marzullo"));
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
