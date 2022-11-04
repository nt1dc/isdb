package com.example.distributed_system.service;

import com.example.distributed_system.dto.WorldResp;
import com.example.distributed_system.entity.World;
import com.example.distributed_system.repository.WorldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class WorldService {
    private final WorldRepository worldRepository;

    private final ModelMapper modelMapper;

    public WorldService(WorldRepository worldRepository, ModelMapper modelMapper) {
        this.worldRepository = worldRepository;
        this.modelMapper = modelMapper;
    }

    public WorldResp findWorldById(Integer id) {
        World world = worldRepository.findById(id).orElseThrow();
        WorldResp map = modelMapper.map(world, WorldResp.class);
        return map;
    }
}
