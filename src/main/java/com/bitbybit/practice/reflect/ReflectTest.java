package com.bitbybit.practice.reflect;

import com.bitbybit.practice.aliyun.PowerTwo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectTest {

    private static final Logger logger = LoggerFactory.getLogger(ReflectTest.class);

    public static void main(String[] args) {
        try {
            Class<?> powerTwo = Class.forName("com.bitbybit.practice.aliyun.PowerTwo");
            Object o = powerTwo.newInstance();
            Method[] methods = powerTwo.getMethods();
            for (Method method : methods) {
                String name = method.getName();
                logger.info("method = {}", name);
            }
            Method[] declaredMethods = powerTwo.getDeclaredMethods();
            for (Method method : declaredMethods) {
                String name = method.getName();
                if (name.equals("test2")) {
                    method.invoke(o, "hello");
                }
                logger.info("declaredMethod = {}", name);
            }
        } catch (Exception e) {
            logger.error("ReflectTest fail", e);
        }

    }
}
