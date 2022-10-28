package com.example.distributed_system.repository;

import com.example.distributed_system.entity.DemonHuman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemonHumanRepository extends JpaRepository<DemonHuman, Integer> {
}