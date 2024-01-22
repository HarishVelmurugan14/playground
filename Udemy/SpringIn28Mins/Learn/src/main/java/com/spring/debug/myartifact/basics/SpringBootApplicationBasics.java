package com.spring.debug.myartifact.basics;

import com.spring.debug.myartifact.scope.DriverScope;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.logging.Logger;

@SpringBootApplication
@ComponentScan("com.spring.debug.myartifact")
public class SpringBootApplicationBasics {

	private static final Logger LOGGER = Logger.getLogger("SpringBootApplicationBasics.class");
	public static void main(String[] args) {
		//Logic 3
		//BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());
		//int result =     binarySearchImpl.binarySearch(new int[] {1,2,3}, 4);
		//System.out.print(result);
		//Logic 4 - All initialization above needs to be handled by the framework instead of us
		//1. What are the beans - displayed by @Component
		//2. What are the dependencies ? - Wired using autowired
	 	//3. Where to search for bean? Same package not needed other package @ComponentScan

		ApplicationContext applicationContext = SpringApplication.run(SpringBootApplicationBasics.class, args);
		//All beans are handled using application context and obtained using above process

		//***************************** Basics ********************************************
		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		LOGGER.info("Binary Search 1 = "+ binarySearch);
		BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
		LOGGER.info("Binary Search 2 = "+ binarySearch2);

		int result1 = binarySearch.binarySearch(new int[] {1,2,3}, 4);
		int result2 = binarySearch2.binarySearch(new int[] {1,2,3}, 4);
		System.out.println(result1);
		System.out.println(result2);
		//***************************** ******* ********************************************
		//***************************** Scope & Component Scan *****************************
		DriverScope driverScope1 = applicationContext.getBean(DriverScope.class);
		DriverScope driverScope2 = applicationContext.getBean(DriverScope.class);
		System.out.println(driverScope1);
		System.out.println(driverScope2);
		driverScope1.accessDriver(applicationContext);
		driverScope2.accessDriver(applicationContext);
		//***************************** ******* ********************************************
	}
}
