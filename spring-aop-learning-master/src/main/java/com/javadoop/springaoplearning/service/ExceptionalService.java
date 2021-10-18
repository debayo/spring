package com.javadoop.springaoplearning.service;

import org.springframework.stereotype.Service;

public interface ExceptionalService {
    public void throwException() throws Exception;
    public void nil();
}