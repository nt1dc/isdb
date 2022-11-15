package com.example.distributed_system.service;

import com.example.distributed_system.entity.Demon;
import com.example.distributed_system.entity.DemonSpecialisation;
import com.example.distributed_system.entity.Human;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class DemonGenerator {
    public static Demon generate(Human human) {
        List<DemonSpecialisation> demonSpecialisations = new ArrayList<>();
        demonSpecialisations.add(new DemonSpecialisation("Веб", 15L));
        demonSpecialisations.add(new DemonSpecialisation("ОПД", 10L));
        var agesLeft = 100 - human.getNumberOfGoodDeeds();
        var specialisation = demonSpecialisations.get(new Random().nextInt(demonSpecialisations.size()));
        return new Demon(agesLeft, Set.of(specialisation));
    }
}
