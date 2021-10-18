package com.javadoop.circulardependency;

import com.javadoop.springaoplearning.service.ExceptionalService;
import com.javadoop.springaoplearning.service.imple.ExceptionalServiceImpl;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javadoop.springaoplearning.service.OrderService;
import com.javadoop.springaoplearning.service.UserService;

/**
 * @author: hongjie
 * @date: 2018/6/18
 */

public class Application {

    public static void main(String[] args) {
         test_Spring_2_0_AspectJ_Exception();
    }


    static ApplicationContext context;
    static AutowireCapableBeanFactory f;
    public static void test_Spring_2_0_AspectJ_Exception()  {
        context= new ClassPathXmlApplicationContext("classpath:spring_2_0_circulardependency.xml");
         f =  context.getAutowireCapableBeanFactory();
        A a = context.getBean(A.class);
    }


}
