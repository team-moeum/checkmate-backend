package com.checkmate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HealthController {
    @GetMapping
    public String version(){
        return "app-version 0.1";
    }

    @GetMapping("/health")
    public String health(){
        log.info("======health check======");
        return "health is ok";
    }
}
