package com.bitbybit.practice.proxy;


/**
 * @author liulin
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        ServiceInterface serviceInterface = new ServiceInterfaceImpl();
        ServiceInterfaceStaticProxy serviceInterfaceStaticProxy = new ServiceInterfaceStaticProxy(serviceInterface);
        serviceInterfaceStaticProxy.doSomething();
    }

}

class ServiceInterfaceStaticProxy implements ServiceInterface {
    private ServiceInterface serviceInterface;

    public ServiceInterfaceStaticProxy(ServiceInterface serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    @Override
    public void doSomething() {
        System.out.println("before");
        this.serviceInterface.doSomething();
        System.out.println("after");
    }
}