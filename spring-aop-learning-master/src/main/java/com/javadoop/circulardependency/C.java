package com.javadoop.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {
    private A a;
    public C() {
        System.out.println("C contructor");
    }
    @Autowired void setA(A a) {
        this.a = a;
    }
}
