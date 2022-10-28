package com.example.distributed_system.repository;

import com.example.distributed_system.entity.Human;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HumanRepository extends JpaRepository<Human, Integer> {
}