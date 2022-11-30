package com.example.distributed_system.service;

import com.example.distributed_system.entity.Demon;
import com.example.distributed_system.entity.DemonSpecialisation;
import com.example.distributed_system.entity.Hell;
import com.example.distributed_system.entity.Human;
import com.example.distributed_system.repository.DemonSpecialisationRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DemonGenerator {

    public Demon generate(Human human, Hell hell) {
        List<DemonSpecialisation> demonSpecialisations = new ArrayList<>();
        demonSpecialisations.add(new DemonSpecialisation("Веб", 15));
        demonSpecialisations.add(new DemonSpecialisation("ОПД", 10));
        var agesLeft = 100 - human.getNumberOfGoodDeeds();
        var specialisation = demonSpecialisations.get(new Random().nextInt(demonSpecialisations.size()));
        Set<DemonSpecialisation> specialisations = new HashSet<>();
        specialisations.add(specialisation);
        return new Demon(agesLeft, specialisations, hell);
    }
}
