package com.chair.auth.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/hello")
    public String hello() {
        log.info("hello auth");
        return "hello auth";
    }
}
