package com.example.distributed_system.service;

import com.example.distributed_system.entity.DistributionCommittee;
import com.example.distributed_system.entity.Distributor;
import com.example.distributed_system.repository.DistributionCommitteeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommitteeService {

    @Autowired
    private DistributionCommitteeRepository committeeRepository;

    public DistributionCommittee addDistributor(Integer committeeId, Distributor distributor) {
        DistributionCommittee distributionCommittee = committeeRepository.findById(committeeId).orElseThrow();
        distributionCommittee.getDistributors().add(distributor);
        committeeRepository.save(distributionCommittee);
        return distributionCommittee;
    }

    public DistributionCommittee findCommittee(Integer committeeId) {
        return committeeRepository.findById(committeeId).orElseThrow();
    }
}
