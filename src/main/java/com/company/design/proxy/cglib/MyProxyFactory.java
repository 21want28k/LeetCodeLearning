package com.company.design.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

public class MyProxyFactory implements MethodInterceptor {
    private Object target;

    public MyProxyFactory(Object target) {
        this.target = target;
    }

    public Object getProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
//        Object returnValue = method.invoke(target, args);
        Object returnValue = proxy.invokeSuper(obj, args);
        after();
        return returnValue;
    }

    public void before() {
        System.out.println(String.format("log start [%s]", new Date()));
    }

    public void after() {
        System.out.println(String.format("log end [%s]", new Date()));
    }
}