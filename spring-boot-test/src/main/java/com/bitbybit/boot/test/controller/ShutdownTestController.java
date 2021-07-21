package com.bitbybit.boot.test.controller;

import com.bitbybit.autoconfigure.idempotence.annotation.Idempotence;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@RestController
@RequestMapping("/shutdown/test")
public class ShutdownTestController {

    private static final Logger logger = LogManager.getLogger(ShutdownTestController.class);

    private static AtomicBoolean atomicBoolean = new AtomicBoolean(Boolean.TRUE);

    @GetMapping("/foreverWork")
    public String foreverWork() throws InterruptedException {

        while (atomicBoolean.get()) {
            logger.info("work will sleep a moment");
            TimeUnit.SECONDS.sleep(30L);
        }

        return "stop";
    }

}
