package com.techriders.instorepickupservice.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailUniqueValidator.class)
public @interface EmailUnique {
    String message() default "{com.EmailUnique.message}";
    Class<?>[] groups() default {};
    public abstract Class<? extends Payload>[] payload() default {};
}
