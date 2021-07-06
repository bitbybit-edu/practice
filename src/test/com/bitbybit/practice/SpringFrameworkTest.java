package com.bitbybit.practice;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

public class SpringFrameworkTest {

    private static final Logger log = LoggerFactory.getLogger(SpringFrameworkTest.class);

    @Test
    public void test1() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
        BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
        log.info(beanA.getName());
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAndImportResource.class);
        BeanA beanA = applicationContext.getBean("beanA", BeanA.class);
        log.info(beanA.getName());

        BeanA configAndImportResourceBeanA = applicationContext.getBean("configAndImportResourceBeanA", BeanA.class);
        log.info(configAndImportResourceBeanA.getName());

        BeanA resourceBeanA = applicationContext.getBean("resourceBeanA", BeanA.class);
        log.info(resourceBeanA.getName());
    }

    @Configuration
    public static class ConfigA {

        @Bean
        public BeanA beanA() {
            return new BeanA();
        }

    }

    @Configuration
    @Import({ConfigA.class})
    @ImportResource("import-resource.xml")
    public static class ConfigAndImportResource {
        @Value("${log4j.rootLogger}")
        private String rootLogger;

        @Bean("configAndImportResourceBeanA")
        public BeanA beanA() {
            BeanA beanA = new BeanA();
            beanA.setName(rootLogger);
            return beanA;
        }

    }




    public static class BeanA {
        public BeanA() {
            this.name = "beanA";
        }

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
