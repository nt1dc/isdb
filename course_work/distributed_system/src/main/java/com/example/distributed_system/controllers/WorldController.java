package com.example.distributed_system.controllers;

import com.example.distributed_system.dto.WorldResp;
import com.example.distributed_system.service.WorldService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/world")
public class WorldController {
    private final WorldService worldService;

    public WorldController(WorldService worldService) {
        this.worldService = worldService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorldResp> getWorld(@PathVariable Integer id) {
        WorldResp worldById = worldService.findWorldById(id);
        return ResponseEntity.ok().body(worldById);
    }
}
