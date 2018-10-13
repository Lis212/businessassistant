package io.khasang.ba.service.impl;

import io.khasang.ba.service.MyService;
import org.springframework.stereotype.Component;

@Component
public class MyServiceImpl implements MyService {
    @Override
    public String getName() {
        return "bean from interface";
    }
}
