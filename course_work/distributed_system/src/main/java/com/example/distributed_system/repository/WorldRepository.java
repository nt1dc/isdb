package com.example.distributed_system.repository;

import com.example.distributed_system.entity.World;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldRepository extends JpaRepository<World, Integer> {
}