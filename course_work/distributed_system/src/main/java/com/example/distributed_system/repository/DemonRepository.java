package com.example.distributed_system.repository;

import com.example.distributed_system.entity.Demon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemonRepository extends JpaRepository<Demon, Integer> {
}