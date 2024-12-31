package com.checkmate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestController {
    @GetMapping("/")
    public String test(){
        return "app version 0.1";
    }

    @GetMapping("/test")
    public void errorTest() throws Exception {
        log.info("info log");
        log.warn("warn log");
        log.error("error log");
        throw new Exception("Error Test");
    }
}
