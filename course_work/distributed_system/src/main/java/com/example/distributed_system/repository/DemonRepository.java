package com.example.distributed_system.repository;

import com.example.distributed_system.entity.Demon;
import com.example.distributed_system.entity.Hell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DemonRepository extends JpaRepository<Demon, Integer> {
    void deleteDemonsByHellId(Integer hell_id);
}