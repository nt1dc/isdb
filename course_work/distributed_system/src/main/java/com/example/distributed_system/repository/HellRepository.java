package com.example.distributed_system.repository;

import com.example.distributed_system.entity.Hell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HellRepository extends JpaRepository<Hell, Integer> {
}