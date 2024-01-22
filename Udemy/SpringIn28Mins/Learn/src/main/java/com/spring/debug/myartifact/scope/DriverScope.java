package com.spring.debug.myartifact.scope;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class DriverScope {

    public void accessDriver(ApplicationContext applicationContext) {

        BaseScope baseScope1 = applicationContext.getBean(BaseScope.class);

        baseScope1.setName("baseScope1");
        System.out.println("Hello object (hello1) Your name is: " + baseScope1.getName());

        BaseScope baseScope2 = applicationContext.getBean(BaseScope.class);
        baseScope2.setName("Test");

        System.out.println("Hello object (hello2) Your name is: " + baseScope2.getName());
        System.out.println("Hello object (hello1) Your name is: " + baseScope1.getName());
        System.out.println("'baseScope1' and 'baseScope2' are referring to the same object: " + (baseScope1 == baseScope2));
        System.out.println("Address of object baseScope1: " + baseScope1);
        System.out.println("Address of object baseScope2: " + baseScope2);
    }
}
