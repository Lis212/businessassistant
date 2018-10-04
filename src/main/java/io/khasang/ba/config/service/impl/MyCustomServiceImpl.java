package io.khasang.ba.config.service.impl;

import io.khasang.ba.config.service.MyService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("main")
public class MyCustomServiceImpl implements MyService {
    @Override
    public String getName() {
        return "custom bean from interface";
    }
}
