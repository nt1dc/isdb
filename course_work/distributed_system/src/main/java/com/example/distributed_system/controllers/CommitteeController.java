package com.example.distributed_system.controllers;


import com.example.distributed_system.entity.DistributionCommittee;
import com.example.distributed_system.entity.Distributor;
import com.example.distributed_system.service.CommitteeService;
import com.example.distributed_system.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/committee")
public class CommitteeController {
    @Autowired
    private CommitteeService committeeService;
    @Autowired
    private DistributorService distributorService;

    @PostMapping("/{committeeId}/distributor")
    public DistributionCommittee addDistributor(@RequestBody Distributor distributor, @PathVariable Integer committeeId) {
        return committeeService.addDistributor(committeeId, distributor);
    }

    @DeleteMapping("/{committeeId}/{distributorID}")
    public DistributionCommittee deleteDistributor(@PathVariable Integer committeeId, @PathVariable Integer distributorID) {
        distributorService.deleteDistributor(distributorID);
        return committeeService.findCommittee(committeeId);
    }
}
