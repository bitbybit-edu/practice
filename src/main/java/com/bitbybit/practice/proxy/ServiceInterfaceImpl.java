package com.bitbybit.practice.proxy;

/**
 * 服务接口具体实现
 */
public class ServiceInterfaceImpl implements ServiceInterface {

    @Override
    public void doSomething() {
        System.out.println("业务的具体实现");
    }

}
