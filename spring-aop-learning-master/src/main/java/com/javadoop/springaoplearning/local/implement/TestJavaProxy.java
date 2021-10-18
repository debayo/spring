package com.javadoop.springaoplearning.local.implement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import sun.misc.ProxyGenerator;

public class TestJavaProxy {
    static interface Singer {
        public void sing();
    }

    static class SingerA implements Singer {

        @Override
        public void sing() {
            System.out.println("SingerA is singing");
        }

    }

    static class MyInvocationHanlder implements InvocationHandler {
        private Object obj;

        public MyInvocationHanlder(Object obj) {
            this.obj = obj;
        }
        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("proxy = " + proxy.getClass().getName() + ", method = " + method.getName() + ", args = " + Arrays.deepToString(args));
            System.out.println("before invoke");
            Object result = method.invoke(this.obj, args);
            System.out.println("after invoke");
            return result;
        }

    }
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        SingerA singer = new SingerA();
        MyInvocationHanlder h = new MyInvocationHanlder(singer);

        Singer proxied = (Singer) Proxy.newProxyInstance(TestJavaProxy.class.getClassLoader(),
                new Class[] { Singer.class }, h);
        proxied.sing();
        System.out.println(proxied.hashCode());
        System.out.println(singer.hashCode());
        System.out.println(proxied.equals(singer));
        System.out.println(proxied == singer);
    }
}
