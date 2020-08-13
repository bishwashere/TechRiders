<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/configs/AuthSuccessHandler.java
package com.techriders.logisticservice.configs;


import com.techriders.logisticservice.domains.User;
import com.techriders.logisticservice.services.UserService;
=======
package com.warehouseService.rabbitmq.configs;

import com.warehouseService.rabbitmq.domains.RolePermission;
import com.warehouseService.rabbitmq.domains.User;
import com.warehouseService.rabbitmq.domains.UserRole;
import com.warehouseService.rabbitmq.services.UserService;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/configs/AuthSuccessHandler.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
<<<<<<< HEAD:warehouseService/src/main/java/com/techriders/logisticservice/configs/AuthSuccessHandler.java
import java.util.Set;
=======
import java.security.Permission;
import java.security.Principal;
import java.util.*;
>>>>>>> 74e49a5e86fbe11f21dd98e2f840978f217ebe7a:warehouseService/src/main/java/com/warehouseService/rabbitmq/configs/AuthSuccessHandler.java

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

        Map<String, ArrayList<String>> roles = new HashMap<String, ArrayList<String>>();
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
