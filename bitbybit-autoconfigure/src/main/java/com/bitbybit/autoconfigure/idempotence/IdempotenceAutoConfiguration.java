package com.bitbybit.autoconfigure.idempotence;

import com.alibaba.fastjson.JSON;
import com.bitbybit.autoconfigure.idempotence.annotation.Idempotence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class IdempotenceAutoConfiguration {

    private static final Logger logger = LogManager.getLogger(IdempotenceAutoConfiguration.class);

    @Aspect
    public static class IdempotenceAspect {

        private static final Logger logger = LogManager.getLogger(IdempotenceAspect.class);

        @Pointcut("@annotation(com.bitbybit.autoconfigure.idempotence.annotation.Idempotence)")
        public void pointcutIdempotenceAnnotation() {

        }

        @Pointcut("execution(public * *(..))")
        public void pointcutSetMethod() {

        }

        @Pointcut("within(com.bitbybit.boot.test.controller.ShutdownTestController)")
        public void targetObjectForPointcutSetMethod() {
        }

        @Around("pointcutIdempotenceAnnotation()")
        public Object adviceIdempotenceAround(ProceedingJoinPoint pjp) throws Throwable {
            // start stopwatch
            Idempotence declaredAnnotation = pjp.getTarget().getClass().getDeclaredAnnotation(Idempotence.class);

            logger.info("bean simple set method advice around before");
            Object retVal = pjp.proceed();
            logger.info("method:{}, args:{}", pjp.getSignature(), JSON.toJSONString(pjp.getArgs()));;
            logger.info("bean simple set method advice around after");
            // stop stopwatch
            return retVal;
        }
    }

    @Bean
    public IdempotenceAspect idempotenceAspect() {
        return new IdempotenceAspect();
    }

}
