package com.example.distributed_system.controllers;

import com.example.distributed_system.dto.WorldResp;
import com.example.distributed_system.service.WorldService;
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
    public void genocideStart(@PathVariable Integer worldId) {
        worldService.genocideStart(worldId);
    }

    @GetMapping("/{worldId}/amnesty")
    public void amnestyStrat(@PathVariable Integer worldId) {
        worldService.amnestyStart(worldId);
    }

    @GetMapping("/{worldId}/nextYear")
    public void nextYear(@PathVariable Integer worldId) {
        worldService.nextYear(worldId);
    }

}
