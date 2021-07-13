package com.bitbybit.practice.spring;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.io.Resource;

public class SpringFrameworkTest {

    private static final Logger log = LogManager.getLogger(SpringFrameworkTest.class);

    @Test
    public void containerSimpleTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
        BeanSimple beanSimple = applicationContext.getBean("beanSimple", BeanSimple.class);
        log.info("{}" , beanSimple.getName());
    }

    @Test
    public void importResourceTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigAndImportResource.class);
        BeanSimple beanSimple = applicationContext.getBean("beanSimple", BeanSimple.class);
        log.info(beanSimple.getName());

        BeanSimple configAndImportResourceBeanSimple = applicationContext.getBean("configAndImportResourceBeanSimple", BeanSimple.class);
        log.info(configAndImportResourceBeanSimple.getName());

        BeanSimple resourceBeanSimple = applicationContext.getBean("resourceBeanSimple", BeanSimple.class);
        log.info(resourceBeanSimple.getName());
    }

    @Configuration
    public static class ConfigA {

        @Bean
        public BeanSimple beanSimple() {
            return new BeanSimple();
        }

    }

    @Configuration
    @Import({ConfigA.class})
    @ImportResource("import-resource.xml")
    public static class ConfigAndImportResource {
        @Value("${log4j.rootLogger}")
        private String rootLogger;

        @Bean("configAndImportResourceBeanSimple")
        public BeanSimple BeanSimple() {
            BeanSimple beanSimple = new BeanSimple();
            beanSimple.setName(rootLogger);
            return beanSimple;
        }

    }

    public static class BeanSimple {
        public BeanSimple() {
            this.name = "beanSimple";
        }

        public BeanSimple(String name) {
            this.name = name;
        }

        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }


    @Configuration
    public static class ConfigProfile {

        public static final String DEVELOPMENT = "development";
        public static final String BEAN_PROFILE_DEVELOPMENT = "beanProfileDevelopment";

        public static final String PRODUCTION = "production";
        public static final String BEAN_PROFILE_PRODUCTION = "beanProfileProduction";

        @Bean(BEAN_PROFILE_DEVELOPMENT)
        @Profile(DEVELOPMENT)
        public BeanSimple beanSimpleDevelopment() {
            BeanSimple beanSimple = new BeanSimple(BEAN_PROFILE_DEVELOPMENT);
            return beanSimple;
        }

        @Bean(BEAN_PROFILE_PRODUCTION)
        @Profile(PRODUCTION)
        public BeanSimple beanSimpleProduction() {
            BeanSimple beanSimple = new BeanSimple(BEAN_PROFILE_PRODUCTION);
            return beanSimple;
        }
    }


    @Test
    public void profileTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles(ConfigProfile.DEVELOPMENT);
        applicationContext.register(ConfigProfile.class);
        applicationContext.refresh();

        BeanSimple beanSimple = applicationContext.getBean(ConfigProfile.BEAN_PROFILE_DEVELOPMENT, BeanSimple.class);
        log.info(beanSimple.getName());

        BeanSimple beanProfileProduction = applicationContext.getBean(ConfigProfile.BEAN_PROFILE_PRODUCTION, BeanSimple.class);
        log.info("{}", beanProfileProduction);
    }

    @Test
    public void aspectTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.getEnvironment().setActiveProfiles(ConfigProfile.DEVELOPMENT);
        applicationContext.register(ConfigProfile.class);
        applicationContext.refresh();

        BeanSimple beanSimple = applicationContext.getBean(ConfigProfile.BEAN_PROFILE_DEVELOPMENT, BeanSimple.class);
        log.info(beanSimple.getName());

        BeanSimple beanProfileProduction = applicationContext.getBean(ConfigProfile.BEAN_PROFILE_PRODUCTION, BeanSimple.class);
        log.info("{}", beanProfileProduction);
    }

    @Configuration
    @EnableAspectJAutoProxy
    public static class AspectConfig {
        @Bean
        public BeanSimple aspectBeanSimple() {
            BeanSimple beanSimple = new BeanSimple("aspectBeanSimple");
            return beanSimple;
        }

        @Bean
        public CommonAspect commonAspect() {

            return new CommonAspect();
        }
    }


    @Aspect
    public static class CommonAspect {

    }

}
