package com.example.distributed_system.repository;

import com.example.distributed_system.entity.Distributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DistributorRepository extends JpaRepository<Distributor, Integer> {
}