package com.warehouseService.rabbitmq.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.*;

@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {

    @Autowired
    HttpServletRequest httpServletRequest;


    @Override
    public boolean hasPermission(Authentication authentication, Object target, Object permission) {

        System.out.println(target);

        Map<String, ArrayList<String>> sessionRoles = (Map<String, ArrayList<String>>)((HttpSession) httpServletRequest.getSession()).getAttribute("permissions");

        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        Iterator roleValues = roles.iterator();

        System.out.println(sessionRoles);

        while (roleValues.hasNext()){
            String roleName = (String) roleValues.next();
            if(sessionRoles.containsKey(roleName)){
                List<String> session_permission = (ArrayList<String>)sessionRoles.get(roleName);
                System.out.println(permission);
                if(session_permission.contains(permission)){
                    return true;
                }
            }

        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        throw new UnsupportedOperationException();
    }

}
