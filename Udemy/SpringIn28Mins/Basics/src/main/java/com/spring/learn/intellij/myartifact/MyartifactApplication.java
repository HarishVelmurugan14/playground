package com.spring.learn.intellij.myartifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class MyartifactApplication {

	public static void main(String[] args) {
		//Logic 3
		//BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());
		//int result = binarySearchImpl.binarySearch(new int[] {1,2,3}, 4);
		//System.out.print(result);
		//Logic 4 - All initialization above needs to be handled by the framework instead of us
		//1. What are the beans - displayed by @Component
		//2. What are the dependencies ? - Wired using autowired
		//3. Where to search for bean? Same package not needed other package @ComponentScan

		ApplicationContext applicationContext = SpringApplication.run(MyartifactApplication.class, args);
		//All beans are handled using application context and obtained using above process

		BinarySearchImpl binarySearch = applicationContext.getBean(BinarySearchImpl.class);
		int result1 = binarySearch.binarySearch(new int[] {1,2,3}, 4);
		System.out.print(result1);

	}


}
