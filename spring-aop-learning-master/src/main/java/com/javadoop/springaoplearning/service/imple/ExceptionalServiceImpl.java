package com.javadoop.springaoplearning.service.imple;

import com.javadoop.springaoplearning.service.ExceptionalService;
import org.springframework.stereotype.Service;

@Service
public class ExceptionalServiceImpl implements ExceptionalService {
    @Override
    public void throwException() throws Exception {
        throw new Exception("test");
    }

    @Override
    public void nil() {

    }
}