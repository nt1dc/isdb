package com.example.distributed_system.service;

import com.example.distributed_system.entity.Human;
import com.example.distributed_system.entity.Sex;
import com.example.distributed_system.entity.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HumanGenerator {
    public static List<Human> generate(int count, World world) {
        String[] namesArr = {"Sasha", "Zhenya", "Sam"};
        String[] lastNameArr = {"Antonovich", "Mokrovich"};
        String[] nationalityArr = {"грузин", "чечен", "айзер"};
        Sex[] sexArr = Sex.values();
        List<Human> humans = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String name = namesArr[new Random().nextInt(namesArr.length)];
            String lastName = lastNameArr[new Random().nextInt(lastNameArr.length)];
            String nationality = nationalityArr[new Random().nextInt(nationalityArr.length)];
            int age = (int) (Math.random() * 30);
            Sex sex = sexArr[new Random().nextInt(sexArr.length)];
            Human human = new Human(age, name, lastName, nationality, sex, world.getRealWorld());
            humans.add(human);
        }
        return humans;
    }
}
