package com.example.distributed_system.service;

import com.example.distributed_system.dto.WorldResp;
import com.example.distributed_system.entity.Human;
import com.example.distributed_system.entity.World;
import com.example.distributed_system.repository.WorldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public WorldResp genocideStart(Integer worldId) {
        World world = worldRepository.findById(worldId).orElseThrow();
        world.getRealWorld().getHumans().forEach(human -> {
            human.setDistributionLayer(world.getDistributionLayer());
            human.setRealWorld(null);
        });
        worldRepository.save(world);
        WorldResp worldResp = modelMapper.map(world, WorldResp.class);
        return worldResp;
    }

    public WorldResp amnestyStart(Integer worldID) {
        World world = worldRepository.findById(worldID).orElseThrow();
        int size = world.getHell().getDemons().size();
        world.getHell().getDemons().clear();
        List<Human> humans = HumanGenerator.generate(size, world);
        world.getRealWorld().getHumans().addAll(humans);
        worldRepository.save(world);
        return modelMapper.map(world, WorldResp.class);
    }

    public WorldResp nextYear(Integer worldId) {
//        todo: ну это нужно сделать а так вроде все готово)
        return null;
    }
}
