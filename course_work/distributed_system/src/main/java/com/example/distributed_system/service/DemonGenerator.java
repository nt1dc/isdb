package com.example.distributed_system.service;

import com.example.distributed_system.entity.Demon;
import com.example.distributed_system.entity.DemonSpecialisation;
import com.example.distributed_system.entity.Hell;
import com.example.distributed_system.entity.Human;
import com.example.distributed_system.repository.DemonSpecialisationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

@Service
public class DemonGenerator {
    private final DemonSpecialisationRepository demonSpecialisationRepository;

    public DemonGenerator(DemonSpecialisationRepository demonSpecialisationRepository) {
        this.demonSpecialisationRepository = demonSpecialisationRepository;

    }

    public Demon generate(Human human, Hell hell) {
        List<DemonSpecialisation> demonSpecialisations = demonSpecialisationRepository.findAll();
        var agesLeft = 100 - human.getNumberOfGoodDeeds();
        var specialisation = demonSpecialisations.get(new Random().nextInt(demonSpecialisations.size()));
        return new Demon(agesLeft, Set.of(specialisation), hell);
    }
}
