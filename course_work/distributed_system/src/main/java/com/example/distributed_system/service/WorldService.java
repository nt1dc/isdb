package com.example.distributed_system.service;

import com.example.distributed_system.dto.WorldResp;
import com.example.distributed_system.entity.*;
import com.example.distributed_system.exceptions.GameOverException;
import com.example.distributed_system.repository.DemonRepository;
import com.example.distributed_system.repository.WorldRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Random;

@Service
public class WorldService {

    private final WorldRepository worldRepository;
    private final DemonRepository demonRepository;

    private final ModelMapper modelMapper;

    public WorldService(WorldRepository worldRepository, DemonRepository demonRepository, ModelMapper modelMapper) {
        this.worldRepository = worldRepository;
        this.demonRepository = demonRepository;
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
        World world = worldRepository.findById(worldId).orElseThrow();
        RealWorld realWorld = world.getRealWorld();
        DistributionLayer distributionLayer = world.getDistributionLayer();
        Hell hell = world.getHell();

//      people to DistributionLayer(
        realWorld.getHumans().forEach(human -> {
            human.setAge(human.getAge() + 1);
            human.setNumberOfGoodDeeds(human.getNumberOfGoodDeeds() + new Random().nextInt(10 + 1));
            human.setNumberOfRighteousDeeds(human.getNumberOfRighteousDeeds() + new Random().nextInt(10 + 1));
            if (human.hashCode() % 5 == 0 || human.getAge() > 60) {
                human.setRealWorld(null);
                human.setDistributionLayer(distributionLayer);
            }
        });


//      check game over
        var totalRequiredScreams = distributionLayer.getDistributionCommittees().stream().mapToInt(distributionCommittee -> distributionCommittee.getDistributors().stream().mapToInt(distributor -> distributor.getDistributorSkills().stream().mapToInt(DistributorSkill::getRequiredScreams).sum()).sum()).sum();

        var hellProducedScreams = hell.getDemons().stream().mapToLong(demon -> demon.getDemonDemonSpecialisations().stream().mapToLong(d -> d.getPower() * demon.getDemonHumen().size()).sum()).sum();
        hell.setProducedScreams(hellProducedScreams);

        var totalScreams = distributionLayer.getScreamsCount() + hell.getProducedScreams();
        if (totalScreams < totalRequiredScreams) {
            throw new GameOverException();
        }

//        human to demon
        hell.getHumans().forEach(human -> {
            long sum = human.getDemonHumen().stream().mapToLong(demon -> demon.getDemonDemonSpecialisations().stream().mapToLong(DemonSpecialisation::getPower).sum()).sum();
            human.setNumberOfRighteousDeeds((int) (human.getNumberOfRighteousDeeds() - sum));
            if (human.getNumberOfRighteousDeeds() <= 0) {
                Demon generate = DemonGenerator.generate(human);
                hell.getDemons().add(generate);
            }
        });

//        demons to human
        hell.getDemons().forEach(demon -> demon.setAgesLeftInHell(demon.getAgesLeftInHell() - 1));
        List<Demon> demons = hell.getDemons().stream().filter(demon -> demon.getAgesLeftInHell() == 0).toList();
        demonRepository.deleteAll(demons);
        List<Human> newPeople = HumanGenerator.generate(demons.size(), world);
        realWorld.getHumans().addAll(newPeople);

        distributionLayer.getHumans().forEach(human -> {
            if (human.getNumberOfGoodDeeds() > human.getNumberOfRighteousDeeds()) {
                human.setDistributionLayer(null);
                human.setRealWorld(realWorld);
            } else {
                human.setDistributionLayer(null);
                human.setHell(hell);
                if (!hell.getDemons().isEmpty()) {
                    Demon demon1 = hell.getDemons().stream().min(Comparator.comparing(demon -> demon.getDemonHumen().size())).get();
                    demon1.getDemonHumen().add(human);
                }
            }
        });

//        BurnNewPeople
        long femaleCount = realWorld.getHumans().stream().filter(human -> human.getAge() > 18 && human.getSex() == Sex.FEMALE).count();
        long maleCount = realWorld.getHumans().stream().filter(human -> human.getAge() > 18 && human.getSex() == Sex.MALE).count();
        List<Human> burnedPeople = HumanGenerator.generate((int) Math.min(femaleCount, maleCount), world);
        realWorld.getHumans().addAll(burnedPeople);


        worldRepository.save(world);
        return modelMapper.map(world, WorldResp.class);
    }
}