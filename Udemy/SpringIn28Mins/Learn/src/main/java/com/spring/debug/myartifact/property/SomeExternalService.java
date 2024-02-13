package com.spring.debug.myartifact.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SomeExternalService {
    @Value("${some.external.url}")
    String url;

    public String getUrl() {
        return url;
    }
}
