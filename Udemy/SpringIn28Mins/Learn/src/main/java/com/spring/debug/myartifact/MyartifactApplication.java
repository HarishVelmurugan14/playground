package com.spring.debug.myartifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class MyartifactApplication {

	private static final Logger LOGGER = Logger.getLogger("MyartifactApplication.class");
	public static void main(String[] args) {
		//Logic 3
		//BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());
		//int result =     binarySearchImpl.binarySearch(new int[] {1,2,3}, 4);
		//System.out.print(result);
		//Logic 4 - All initialization above needs to be handled by the framework instead of us
		//1. What are the beans - displayed by @Component
		//2. What are the dependencies ? - Wired using autowired
	 	//3. Where to search for bean? Same package not needed other package @ComponentScan

		ApplicationContext applicationContext = SpringApplication.run(MyartifactApplication.class, args);
		//All beans are handled using application context and obtained using above process

		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		LOGGER.info("Binary Search 1 = "+ binarySearch);
		BinarySearchImpl binarySearch2 = applicationContext.getBean(BinarySearchImpl.class);
		LOGGER.info("Binary Search 2 = "+ binarySearch2);

		int result1 = binarySearch.binarySearch(new int[] {1,2,3}, 4);
		int result2 = binarySearch2.binarySearch(new int[] {1,2,3}, 4);
		System.out.println(result1);
		System.out.println(result2);
	}


}
