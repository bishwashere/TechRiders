package com.techriders.wirehouseservice.annotations;

import com.techriders.wirehouseservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserNameUniqueValidator implements ConstraintValidator<UserNameUnique, String> {

    @Autowired
    UserService userService;


    @Override
    public void initialize(UserNameUnique constraintAnnotation) {

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(userService == null){
            return true;
        }else if(userService.findByUserName(value) == null){
            return true;
        }else{
            return false;
        }

    }
}
