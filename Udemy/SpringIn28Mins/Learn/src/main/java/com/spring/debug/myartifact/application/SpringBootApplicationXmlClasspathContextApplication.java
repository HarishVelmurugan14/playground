package com.spring.debug.myartifact.application;

import com.spring.debug.myartifact.xml.XmlPersonDAO;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SpringBootApplicationXmlClasspathContextApplication {

	private static final Logger LOGGER = Logger.getLogger("SpringBootApplicationXmlClasspathContextApplication.class");
	public static void main(String[] args) {

		try(ClassPathXmlApplicationContext applicationContext =
				new ClassPathXmlApplicationContext("applicationcontext.xml")) {
			//All beans are handled using application context and obtained using above process

			LOGGER.log(Level.INFO, "All Beans Loaded -> {0}", Arrays.toString(applicationContext.getBeanDefinitionNames()));
			//***************************** Basics ********************************************
			XmlPersonDAO personDAO = applicationContext.getBean(XmlPersonDAO.class);
			LOGGER.info("PersonDAO = " + personDAO);
		}
	}
}
