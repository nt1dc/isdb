package com.example.distributed_system.service;

import com.example.distributed_system.entity.DistributionCommittee;
import com.example.distributed_system.entity.Distributor;
import com.example.distributed_system.entity.World;
import com.example.distributed_system.repository.DistributorRepository;
import com.example.distributed_system.repository.WorldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;

@Service
@Transactional
public class DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;
    @Autowired
    private WorldRepository worldRepository;

    public void deleteDistributor(Integer distributorID) {
//        мне в падлу делать проверку)
        distributorRepository.deleteById(distributorID);
    }

    public void addDistributor(Integer worldId, Distributor distributor) {
        World world = worldRepository.findById(worldId).orElseThrow();
        DistributionCommittee committee = world.getDistributionLayer().getDistributionCommittees().stream()
                .min(Comparator.comparing(distributionCommittee -> distributionCommittee.getDistributors().size())).orElseThrow();
        if (committee.getDistributors().size() < 5) {
            committee.getDistributors().add(distributor);
        } else {
            DistributionCommittee distributionCommittee = new DistributionCommittee();
            distributionCommittee.getDistributors().add(distributor);
            world.getDistributionLayer().getDistributionCommittees().add(distributionCommittee);
        }
        worldRepository.save(world);
    }
}
