package com.bitbybit.practice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class SpringFrameworkTest {

    private static final Logger log = LoggerFactory.getLogger(SpringFrameworkTest.class);

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
        BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
        log.info(beanA.getName());
    }

    @Configuration
    public static class ConfigA {

        @Bean
        public BeanA beanA() {
            return new BeanA();
        }

    }

    public static class BeanA {
        private String name;

        public String getName() {
            return "beanA";
        }
    }

}
