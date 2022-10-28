package com.example.distributed_system.repository;

import com.example.distributed_system.entity.RealWorld;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealWorldRepository extends JpaRepository<RealWorld, Integer> {
}