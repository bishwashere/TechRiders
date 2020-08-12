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
        System.out.println("hhhh------------------------"+o1);
//        return authentication.getAuthorities().contains(o1);
        return true;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        throw new UnsupportedOperationException();
    }

}
