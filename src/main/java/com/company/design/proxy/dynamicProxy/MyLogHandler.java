package com.company.design.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Date;

public class MyLogHandler implements InvocationHandler {
    // 被代理对象
    private Object target;

    public MyLogHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        // 让被代理对象执行具体方法。invoke的第一个参数的意思是，谁来调用这个方法。
        Object result = method.invoke(target, args);
        after();
        return result;
    }

    public void before() {
        System.out.println(String.format("log start [%s]", new Date()));
    }

    public void after() {
        System.out.println(String.format("log end [%s]", new Date()));
    }
}
