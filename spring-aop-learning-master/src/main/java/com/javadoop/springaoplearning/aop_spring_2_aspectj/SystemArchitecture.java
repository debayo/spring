package com.javadoop.springaoplearning.aop_spring_2_aspectj;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

@Aspect
public class SystemArchitecture {

    @Pointcut("within(com.javadoop.springaoplearning.web..*)")
    public void inWebLayer() {}

    @Pointcut("within(com.javadoop.springaoplearning.service..*)")
    public void businessService() {}

    @AfterThrowing(pointcut = "execution(* com.javadoop.springaoplearning.service.*.throwException(..))", throwing = "ex")
    public void logError(Exception ex) {
        System.out.println("Cached exception = " + ex.getStackTrace());
    }

}
