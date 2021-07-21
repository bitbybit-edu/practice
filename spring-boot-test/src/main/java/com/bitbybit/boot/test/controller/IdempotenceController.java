package com.bitbybit.boot.test.controller;

import com.bitbybit.autoconfigure.idempotence.annotation.Idempotence;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/idempotence/test")
public class IdempotenceController {

    @GetMapping
    @Idempotence
    public String idempotenceTest(){
        return "hello";
    }

}
