package com.bitbybit.practice.spring;

import com.alibaba.fastjson.JSON;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

public class SpringFrameworkTest {

    private static final Logger log = LogManager.getLogger(SpringFrameworkTest.class);

    @Test
    public void containerSimpleTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigA.class);
        BeanSimple beanSimple = applicationContext.getBean("beanSimple", BeanSimple.class);
        log.info("{}", beanSimple.getName());
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
            log.info("[set name] param:{}", name);
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
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AspectConfig.class);
        BeanSimple beanSimple = applicationContext.getBean(AspectConfig.ASPECT_BEAN_SIMPLE, BeanSimple.class);
        beanSimple.setName(beanSimple.getName() + "1");

    }

    @Configuration
    @EnableAspectJAutoProxy
    public static class AspectConfig {

        public static final String ASPECT_BEAN_SIMPLE = "aspectBeanSimple";

        @Bean
        public BeanSimple aspectBeanSimple() {
            BeanSimple beanSimple = new BeanSimple(ASPECT_BEAN_SIMPLE);
            return beanSimple;
        }

        @Bean
        public CommonPointcuts commonPointcuts() {

            return new CommonPointcuts();
        }
    }


    @Aspect
    public static class CommonPointcuts {

        @Pointcut("execution(public void set*(..))")
        public void pointcutSetMethod() {

        }

        @Pointcut("within(com.bitbybit.practice.spring.SpringFrameworkTest.BeanSimple)")
        public void targetObjectForPointcutSetMethod() {
        }

//        @Before("pointcutSetMethod() && targetObjectForPointcutSetMethod()")
//        public void adviceSetMethodBefore() {
//            log.info("bean simple set method advice before");
//        }

//        @After("pointcutSetMethod() && targetObjectForPointcutSetMethod()")
//        public void adviceSetMethodAfter() {
//            log.info("bean simple set method advice after");
//        }

        @Around("pointcutSetMethod() && targetObjectForPointcutSetMethod()")
        public Object adviceSetMethodAround(ProceedingJoinPoint pjp) throws Throwable {
            // start stopwatch
            log.info("bean simple set method advice around before");
            Object retVal = pjp.proceed();
            log.info("method:{}, args:{}", pjp.getSignature(), JSON.toJSONString(pjp.getArgs()));;
            log.info("bean simple set method advice around after");
            // stop stopwatch
            return retVal;
        }

        
        public void adviceSetMethodAround() {
            log.info("bean simple set method advice around");
        }

    }

}
