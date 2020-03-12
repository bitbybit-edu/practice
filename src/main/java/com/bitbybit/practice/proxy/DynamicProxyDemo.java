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
        ServiceInterface serviceInterface = (ServiceInterface) Proxy.newProxyInstance(serviceInterfaceImpl.getClass().getClassLoader(), ServiceInterfaceImpl.class.getInterfaces(), new BeforeAfterInvocationHandler(serviceInterfaceImpl));
        serviceInterface.doSomething();
    }
}

class BeforeAfterInvocationHandler implements InvocationHandler {

    private Object object;

    public BeforeAfterInvocationHandler(Object object){
        this.object = object;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("----before----");
        Object invoke = method.invoke(object, args);
        System.out.println("----after----");
        return invoke;
    }
}
