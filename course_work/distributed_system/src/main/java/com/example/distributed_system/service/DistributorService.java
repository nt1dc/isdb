package com.example.distributed_system.service;

import com.example.distributed_system.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistributorService {
    @Autowired
    private DistributorRepository distributorRepository;

    public void deleteDistributor(Integer committeeId, Integer distributorID) {
//        мне в падлу делать проверку)
        distributorRepository.deleteById(distributorID);
    }
}
