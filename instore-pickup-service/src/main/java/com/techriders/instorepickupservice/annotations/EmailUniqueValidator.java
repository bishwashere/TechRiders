package com.techriders.instorepickupservice.annotations;


import com.techriders.instorepickupservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<EmailUnique, String> {

    @Autowired
    UserService userService;


    @Override
    public void initialize(EmailUnique constraintAnnotation) {

    }
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(userService == null){
            return true;
        }else if(userService.findByEmail(value) == null){
            return true;
        }else{
            return false;
        }

    }
}
