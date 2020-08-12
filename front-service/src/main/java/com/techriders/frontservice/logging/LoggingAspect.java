//package com.techriders.frontservice.logging;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class LoggingAspect {
//
//    Logger log = LoggerFactory.getLogger(LoggingAspect.class);
//
//    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void getMethodsPointcut(){}
//
//    @Pointcut(value = "@annotation(org.springframework.web.bind.annotation.PostMapping)")
//    public void postMethodsPointcut(){}
//
//    @Pointcut(value = "execution(* com.techriders.frontservice.services.impl..*(..))")
//    public void serviceMethodsPointcut(){}
//
//    @Before("getMethodsPointcut()")
//    public void getRequestsLogger(JoinPoint joinPoint){
//        String methodName = joinPoint.getSignature().getName();
//        String className = joinPoint.getTarget().getClass().toString();
//
//        log.info("GET " + className + ":" + methodName+"()");
//    }
//
//    @Before("postMethodsPointcut()")
//    public void postRequestsLogger(JoinPoint joinpoint){
//        String methodName = joinpoint.getSignature().getName();
//        String className = joinpoint.getTarget().getClass().toString();
//
//        log.info("POST " + className + ":" + methodName+"()");
//    }
//
////    @Around("serviceMethodsPointcut()")
////    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {
////        ObjectMapper mapper = new ObjectMapper();
////        String methodName = pjp.getSignature().getName();
////        String className = pjp.getTarget().getClass().toString();
////        Object[] arguments = pjp.getArgs();
////        log.info("Method invoked " + className + ":" + methodName+"()" + " Arguments: " + mapper.writeValueAsString(arguments));
////
////        //method's return object
////        Object object = pjp.proceed();
////
////        log.info(className + ":" + methodName+"()" + " Response: " + mapper.writeValueAsString(object));
////        return object;
////    }
//}
