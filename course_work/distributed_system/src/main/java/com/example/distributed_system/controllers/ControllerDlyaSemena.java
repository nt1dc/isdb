package com.example.distributed_system.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDlyaSemena {
    @GetMapping("")
    public Integer getWorldId() {
        return 1;
    }
}
