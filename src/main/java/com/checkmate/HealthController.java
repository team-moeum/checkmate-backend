package com.checkmate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/health")
public class HealthController {
    @GetMapping
    public String health(){
        return "health is ok";
    }
}
