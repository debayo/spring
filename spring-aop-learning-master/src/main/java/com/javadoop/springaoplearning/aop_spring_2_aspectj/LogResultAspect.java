package com.javadoop.springaoplearning.aop_spring_2_aspectj;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author: hongjie
 * @date: 2018/6/11
 */
@Component
@Aspect
public class LogResultAspect {

    private boolean trace = true;

    @AfterReturning(pointcut = "com.javadoop.springaoplearning.aop_spring_2_aspectj.SystemArchitecture.businessService()",
            returning = "result")
    public void logResult(Object result) {
        if (trace) {
            System.out.println("[@AspectJ]返回值：" + result);
        }
    }

    public void setTrace(boolean trace) {
        this.trace = trace;
    }
}
