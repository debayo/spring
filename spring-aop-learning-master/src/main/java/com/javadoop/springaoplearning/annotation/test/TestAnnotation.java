package com.javadoop.springaoplearning.annotation.test;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestAnnotation {
    @RestController
    class B {

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(B.class.getInterfaces()));
        System.out.println(B.class.getDeclaredAnnotation(Controller.class));
        Annotation annotation =  findAnnotation(B.class, Controller.class, new HashSet<>());
        System.out.println(annotation);

    }

    //递归查找Annotation
    private static   Annotation findAnnotation(Class clazz, Class annotationType, Set<Annotation> visited) {
        try {
            Annotation annotation = clazz.getDeclaredAnnotation(annotationType);
            if (annotation != null) {
                return annotation;
            }
            for (Annotation declaredAnn : clazz.getDeclaredAnnotations()) {
                Class<? extends Annotation> declaredType = declaredAnn.annotationType();
                if (!isInJavaLangAnnotationPackage(declaredType) && visited.add(declaredAnn)) {
                    annotation = findAnnotation(declaredType, annotationType, visited);
                    if (annotation != null) {
                        return annotation;
                    }
                }
            }
        }
        catch (Throwable ex) {
            return null;
        }

        for (Class<?> ifc : clazz.getInterfaces()) {
            Annotation annotation = findAnnotation(ifc, annotationType, visited);
            if (annotation != null) {
                return annotation;
            }
        }

        Class<?> superclass = clazz.getSuperclass();
        if (superclass == null || Object.class == superclass) {
            return null;
        }
        return findAnnotation(superclass, annotationType, visited);
    }

    static boolean isInJavaLangAnnotationPackage(@Nullable Class<? extends Annotation> annotationType) {
        return (annotationType != null && isInJavaLangAnnotationPackage(annotationType.getName()));
    }
    public static boolean isInJavaLangAnnotationPackage(@Nullable String annotationType) {
        return (annotationType != null && annotationType.startsWith("java.lang.annotation"));
    }
}
