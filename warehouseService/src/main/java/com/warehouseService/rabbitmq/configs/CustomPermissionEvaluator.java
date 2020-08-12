package com.warehouseService.rabbitmq.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {


    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        System.out.println("hhhh------------------------");
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        System.out.println("hhh2------------------------");
        throw new UnsupportedOperationException();
    }

}
