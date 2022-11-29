package com.example.distributed_system.service;

import com.example.distributed_system.entity.DistributionCommittee;
import com.example.distributed_system.entity.Distributor;
import com.example.distributed_system.repository.DistributionCommitteeRepository;
import com.example.distributed_system.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitteeService {

    @Autowired
    private DistributionCommitteeRepository committeeRepository;


    public DistributionCommittee findDistributionCommittee(Integer committeeId) {
        return committeeRepository.findById(committeeId).orElseThrow();
    }
}
