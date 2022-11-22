package com.example.distributed_system.controllers;


import com.example.distributed_system.entity.DistributionCommittee;
import com.example.distributed_system.entity.Distributor;
import com.example.distributed_system.service.CommitteeService;
import com.example.distributed_system.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.function.Function;

@RestController
@RequestMapping("/committee")
public class CommitteeController {
    @Autowired
    private CommitteeService committeeService;
    @Autowired
    private DistributorService distributorService;

    @PostMapping("/{committeeId}/distributor")
    public void addDistributor(@RequestBody Distributor distributor, @PathVariable Integer committeeId) {
        committeeService.addDistributor(committeeId, distributor);
    }

    @DeleteMapping("/{committeeId}/{distributorID}")
    public void deleteDistributor(@PathVariable Integer distributorID, @PathVariable Integer committeeId) {
        distributorService.deleteDistributor(committeeId,distributorID);

    }

    @GetMapping("{committeeId}")
    public DistributionCommittee getDistributionCommittee(@PathVariable Integer committeeId) {
        return committeeService.findDistributionCommittee(committeeId);
    }
}
