package com.bitbybit.practice.logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.info("test logger");
        logger.error("test logger");
        m();
        A a = new A();
        a.a();
    }

    public static void m() {
        logger.error("test logger m method");
    }
}

class A {
    private static final Logger logger = LoggerFactory.getLogger(A.class);

    public void a() {
        logger.error("test logger A a method");
    }
}
