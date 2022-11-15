package com.example.distributed_system.service;

import com.example.distributed_system.entity.DistributionCommittee;
import com.example.distributed_system.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;

    public void deleteDistributor(Integer distributorID) {
        distributorRepository.deleteById(distributorID);
    }
}
