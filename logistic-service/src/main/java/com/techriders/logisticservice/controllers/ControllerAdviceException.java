package com.techriders.logisticservice.controllers;


import com.techriders.logisticservice.ErrorClass.DomainError;
import com.techriders.logisticservice.ErrorClass.DomainErrors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@ControllerAdvice
public class ControllerAdviceException {

    @Autowired
    MessageSourceAccessor messageAccessor;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public DomainErrors handleException(MethodArgumentNotValidException exception) {
        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        DomainErrors errors = new DomainErrors();
        errors.setErrorType("ValidationError");

        for (FieldError fieldError : fieldErrors) {
            DomainError error = new DomainError(messageAccessor.getMessage(fieldError));
            errors.addError(error);
        }

        return errors;
    }


}
