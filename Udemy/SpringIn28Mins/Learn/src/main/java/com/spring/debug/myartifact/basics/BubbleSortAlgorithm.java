package com.spring.debug.myartifact.basics;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Primary
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class BubbleSortAlgorithm implements SortAlgorithm {

    @Override
    public int[] sort(int[] numbers) {
        //Assume that bubble sort logic is included
        return numbers;
    }

    public void getBubble(){
        System.out.println("Hello");
    }
}