package com.spring.learn.myartifact;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyartifactApplication {

	public static void main(String[] args) {
		BinarySearchImpl binarySearchImpl = new BinarySearchImpl(new BubbleSortAlgorithm());
		int result = binarySearchImpl.binarySearch(new int[] {1,2,3}, 4);
		System.out.print(result);
		//SpringApplication.run(MyartifactApplication.class, args);
	}

}
