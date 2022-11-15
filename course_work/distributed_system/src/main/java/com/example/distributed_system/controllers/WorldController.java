package com.example.distributed_system.controllers;

import com.example.distributed_system.dto.WorldResp;
import com.example.distributed_system.service.WorldService;
import io.swagger.models.auth.In;
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

    @GetMapping("/{worldId}")
    public WorldResp getWorld(@PathVariable Integer worldId) {
        return worldService.findWorldById(worldId);
    }

    @GetMapping("/{worldId}/genocide")
    public WorldResp genocideStart(@PathVariable Integer worldId) {
        return worldService.genocideStart(worldId);
    }

    @GetMapping("/{worldId}/amnesty")
    public WorldResp amnestyStrat(@PathVariable Integer worldId) {
        return worldService.amnestyStart(worldId);
    }

    @GetMapping("/{worldId}/nextYear")
    public WorldResp nextYear(@PathVariable Integer worldId) {
        return worldService.nextYear(worldId);
    }

}