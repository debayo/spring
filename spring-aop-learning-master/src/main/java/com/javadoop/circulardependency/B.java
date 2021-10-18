package com.javadoop.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class B {
    private A a;
    public B() {
        System.out.println("B contructor");
    }
    @Autowired void setA(A a) {
        this.a = a;
    }
}
