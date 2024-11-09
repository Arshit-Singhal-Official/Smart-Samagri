package com.smartsamagri.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmartsamagriController {
    
    @GetMapping("/health")
    public String home() {
        return "Healthy";
    }
    
}
