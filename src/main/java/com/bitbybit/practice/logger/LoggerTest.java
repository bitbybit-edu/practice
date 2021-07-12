package com.bitbybit.practice.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

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


    static class A {
        private static final Logger logger = LogManager.getLogger(A.class);

        public void a() {
            logger.error("test logger A a method");
        }
    }
}

