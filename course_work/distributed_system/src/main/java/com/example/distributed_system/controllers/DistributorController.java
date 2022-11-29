package com.example.distributed_system.controllers;


import com.example.distributed_system.entity.Distributor;
import com.example.distributed_system.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/distributor")
public class DistributorController {
    @Autowired
    private DistributorService distributorService;

    @PostMapping("/{worldId}")
    public void addDistributor(@RequestBody Distributor distributor, @PathVariable Integer worldId) {
        distributorService.addDistributor(worldId, distributor);
    }

    @DeleteMapping("/{distributorID}")
    public void deleteDistributor(@PathVariable Integer distributorID) {
        distributorService.deleteDistributor(distributorID);

    }

}
