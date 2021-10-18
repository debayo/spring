package com.javadoop.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A {
    private B b;
    private C c;

    public A() {
        System.out.println("A contructor");
    }
    @Autowired
    void setB(B b) {
        this.b = b;
    }

    @Autowired
    void setC(C c) {
        this.c = c;
    }
}
