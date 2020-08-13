package com.warehouseService.rabbitmq.configs;

import com.warehouseService.rabbitmq.domains.RolePermission;
import com.warehouseService.rabbitmq.domains.User;
import com.warehouseService.rabbitmq.domains.UserRole;
import com.warehouseService.rabbitmq.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    HttpSession session;

    @Autowired
    UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {



        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        User user = userService.findByUserName(userDetails.getUsername());

        Map<String, ArrayList<String>> roles = new HashMap<>();
        for (UserRole userRole:user.getUserRoles()) {
            List<String> permissionList = new ArrayList<String>();
            for (RolePermission rolePermission:userRole.getRolePermissions()) {
                permissionList.add(rolePermission.getName());
                System.out.println(rolePermission.getName());
            }
            roles.put(userRole.getRoleName(), (ArrayList<String>) permissionList);
        }

        httpServletRequest.getSession().setAttribute("permissions",roles);

        httpServletResponse.sendRedirect("/administration");

    }
}
