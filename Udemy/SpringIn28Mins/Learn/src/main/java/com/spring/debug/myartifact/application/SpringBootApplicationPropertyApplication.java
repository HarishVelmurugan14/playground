package com.spring.debug.myartifact.application;

import com.spring.debug.myartifact.property.SomeExternalService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan("com.spring.debug.myartifact.property")
@PropertySource("classpath:app.properties")
public class SpringBootApplicationPropertyApplication {

	private static final Logger LOGGER = Logger.getLogger("SpringBootApplicationPropertyApplication.class");
	public static void main(String[] args) {

		try(AnnotationConfigApplicationContext applicationContext =
					new AnnotationConfigApplicationContext(SpringBootApplicationPropertyApplication.class)){

			//All beans are handled using application context and obtained using above process

			//LOGGER.log(Level.INFO, "All Beans Loaded -> {0}", Arrays.toString(applicationContext.getBeanDefinitionNames()));
			//***************************** Basics ********************************************
			SomeExternalService someExternalService = applicationContext.getBean(SomeExternalService.class);
			LOGGER.log(Level.INFO,"Some External Service -> {0}" , someExternalService.getUrl());
		}
	}
}
