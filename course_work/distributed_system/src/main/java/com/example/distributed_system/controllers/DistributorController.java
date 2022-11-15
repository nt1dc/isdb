package com.example.distributed_system.controllers;

import com.example.distributed_system.entity.DistributionCommittee;
import com.example.distributed_system.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distributor")
public class DistributorController {
    @Autowired
    private DistributorService distributorService;

    @DeleteMapping("/{distributorID}")
    public void deleteDistributor(@PathVariable Integer distributorID) {
        distributorService.deleteDistributor(distributorID);
    }
}
