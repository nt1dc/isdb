package com.example.distributed_system.repository;

import com.example.distributed_system.entity.DistributionCommittee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributionCommitteeRepository extends JpaRepository<DistributionCommittee, Integer> {
}