package com.bitbybit.practice.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理demo
 *
 * @author liulin
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        ServiceInterface serviceInterfaceImpl = new ServiceInterfaceImpl();
        ClassLoader classLoader = serviceInterfaceImpl.getClass().getClassLoader();
        Class<?>[] interfaces = ServiceInterfaceImpl.class.getInterfaces();
        BeforeAfterInvocationHandler beforeAfterInvocationHandler = new BeforeAfterInvocationHandler(serviceInterfaceImpl);
        ServiceInterface serviceInterface = (ServiceInterface) Proxy.newProxyInstance(classLoader, interfaces, beforeAfterInvocationHandler);
        serviceInterface.doSomething();
    }
}

class BeforeAfterInvocationHandler<T> implements InvocationHandler {

    private T t;

    public BeforeAfterInvocationHandler(T t) {
        this.t = t;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----before----");
        Object invoke = method.invoke(t, args);
        System.out.println("----after----");
        return invoke;
    }
}
