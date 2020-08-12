package com.warehouseService.rabbitmq.configs;

import com.warehouseService.rabbitmq.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Permission;
import java.security.Principal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

@Configuration
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    HttpSession session;

    @Autowired
    UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Set<SimpleGrantedAuthority> authList = new HashSet<SimpleGrantedAuthority>();

//
//        Set<SimpleGrantedAuthority> authList = new HashSet<SimpleGrantedAuthority>();
//
//        authentication.getAuthorities().addAll(authList);

//        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//
//
//        System.out.println(authentication.getAuthorities()+"jkkjhjghjkjgfjkjgjkhjg");
//
////        authentication.getAuthorities().add(authority);
//
//
//        if (roles.contains("ROLE_ADMIN")) {
//            httpServletResponse.sendRedirect("/administration");
//        } else {
//            httpServletResponse.sendRedirect("/");
//        }
    }
}
